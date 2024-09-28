/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Instructor;
import java.sql.*;

/**
 *
 * @author stephhoang
 */
public class InstructorDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Instructor> getAll() {

        List<Instructor> list = new ArrayList<>();

        String sql = "Select * FROM Instructors";

        try {

            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Instructor ins = new Instructor(
                        resultSet.getString("InstructorID"),
                        resultSet.getString("InstructorName"),
                        resultSet.getDate("BirthDate"),
                        resultSet.getInt("Gender"),
                        resultSet.getString("SubjectID")
                );
                list.add(ins);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
