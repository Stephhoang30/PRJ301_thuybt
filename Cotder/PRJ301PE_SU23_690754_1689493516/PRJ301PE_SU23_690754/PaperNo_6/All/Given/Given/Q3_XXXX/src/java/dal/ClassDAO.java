/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Class;

/**
 *
 * @author stephhoang
 */
public class ClassDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Class> findAll() {
        List<Class> listClass = new ArrayList<>();
        try {
            // tao ra ket noi
            connection = new DBContext().connection;

            // cau lenh sql
            String sql = "SELECT *\n"
                    + "FROM Classes";

            // preparedStatement
            statement = connection.prepareStatement(sql);

            // thuc thi cau lenh
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int classID = resultSet.getInt("ClassID");
                String className = resultSet.getString("ClassName");
                
                Class c = new Class();
                
                c.setClassID(classID);
                c.setClassName(className);

                // add vao trong list
                listClass.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listClass;
    }
    
    public static void main(String[] args) {
        for (Class class1 : new ClassDAO().findAll()) {
            System.out.println(class1);
        }
    }
}
