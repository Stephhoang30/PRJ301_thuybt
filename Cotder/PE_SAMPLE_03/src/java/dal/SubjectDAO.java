/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Subjects;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author stephhoang
 */
public class SubjectDAO extends DBContext {
    
    protected PreparedStatement statement;
    protected ResultSet resultSet;
    
    public List<Subjects> findAll() {
        List<Subjects> list = new ArrayList<>();
        try {
            // tao ra ket noi
            connection = new DBContext().connection;

            // cau lenh sql
            String sql = "SELECT *\n"
                    + "FROM Subjects";
            
            // preparedStatement
            statement = connection.prepareStatement(sql);
            
            // thuc thi cau lenh
            resultSet = statement.executeQuery();
           
            while(resultSet.next()) {
                String SubjectID = resultSet.getString("SubjectID");
                String SubjectName = resultSet.getString("SubjectName");
                
                Subjects obj = new Subjects();
                obj.setSubjectID(SubjectID);
                obj.setSubjectName(SubjectName);
                
                // add vao trong list
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
   
    public static void main(String[] args) {
        for (Subjects subjects : new SubjectDAO().findAll()) {
            System.out.println(subjects);
        }
    }
}
