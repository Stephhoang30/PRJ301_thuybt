/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Subject;


/**
 *
 * @author stephhoang
 */
public class SubjectDAO extends DBContext{
    
    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Subject> getAll() {

        List<Subject> list = new ArrayList<>();

        String sql = "Select * FROM Subjects";

        try {

            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Subject sub = new Subject(
                        resultSet.getString("SubjectID"),
                        resultSet.getString("SubjectName")             
                );
                list.add(sub);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
