/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public List<Instructor> findAll() {
        List<Instructor> list = new ArrayList<>();
        try {
            // tao ra ket noi
            connection = new DBContext().connection;

            // cau lenh sql
            String sql = "SELECT *\n"
                    + "FROM Instructors";

            // preparedStatement
            statement = connection.prepareStatement(sql);

            // thuc thi cau lenh
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String instructorID = resultSet.getString("InstructorID");
                String instrutorName = resultSet.getString("InstructorName");
                Date birthDate = resultSet.getDate("BirthDate");
                boolean gender = resultSet.getBoolean("Gender");
                int classID = resultSet.getInt("ClassID");

                Instructor ins = new Instructor();

                ins.setInstructorID(instructorID);
                ins.setInstructorName(instrutorName);
                ins.setBirthDate(birthDate);
                ins.setGender(gender);
                ins.setClassID(classID);

                // add vao trong list
                list.add(ins);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateINS(Instructor ins, String oldID) {
        try {

            connection = new DBContext().connection;

            String sql = "UPDATE [dbo].[Instructors]\n"
                    + "SET\n"
                    + "    [InstructorID] = ?,\n"
                    + "    [InstructorName] = ?,\n"
                    + "    [BirthDate] = ?,\n"
                    + "    [Gender] = ?,\n"
                    + "    [ClassID] = ?\n"
                    + "WHERE [InstructorID] = ?";

            statement = connection.prepareStatement(sql);

            statement.setObject(1, ins.getInstructorID());
            statement.setObject(2, ins.getInstructorName());
            statement.setObject(3, ins.getBirthDate());
            statement.setObject(4, ins.isGender());
            statement.setObject(5, ins.getClassID());
            statement.setObject(6, oldID);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
