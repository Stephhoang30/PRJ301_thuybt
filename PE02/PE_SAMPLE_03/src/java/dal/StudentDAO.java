
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Students;
import model.Subjects;
import java.sql.*;

/**
 *
 * @author stephhoang
 */
public class StudentDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Students> findBySBID(String subjectID) {
        List<Students> list = new ArrayList<>();
        try {
            // tao ra ket noi
            connection = new DBContext().connection;

            // cau lenh sql
            String sql = "SELECT *\n"
                    + "FROM Students\n"
                    + "WHERE Students.SubjectID = ?";

            // preparedStatement
            statement = connection.prepareStatement(sql);
            
            // set parameter
            statement.setObject(1, subjectID);

            // thuc thi cau lenh
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String StudentID = resultSet.getString("StudentID");
                String StudentName = resultSet.getString("StudentName");
                Date birthDate = resultSet.getDate("BirthDate");
                boolean gender = resultSet.getBoolean("Gender");
                String SubjectID = resultSet.getString("SubjectID");

                Students obj = new Students();
                obj.setStudentID(StudentID);
                obj.setStudentName(StudentName);
                obj.setBirthDate(birthDate);
                obj.setGender(gender);
                obj.setSubjectID(SubjectID);

                // add vao trong list
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
