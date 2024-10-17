/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author stephhoang
 */
public class StudentDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        
        try {
            // Prepare the SQL query
            statement = connection.prepareStatement(sql);
            
            // Execute the query
            resultSet = statement.executeQuery();
            
            // Loop through the result set and add each student to the list
            while (resultSet.next()) {
                Student student = new Student();
                
                student.setID(resultSet.getString("ID"));
                student.setName(resultSet.getString("Name"));
                student.setDOB(resultSet.getDate("DOB"));
                student.setGender(resultSet.getBoolean("Gender"));
                student.setAddress(resultSet.getString("Address"));
                
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public void insert(Student student) {
        String sql = "INSERT INTO Student (ID, Name, DOB, Gender, Address) VALUES (?, ?, ?, ?, ?)";
        try {
            // Prepare the SQL statement
            statement = connection.prepareStatement(sql);
            
            // Set the parameters
            statement.setString(1, student.getID());
            statement.setString(2, student.getName());
            statement.setDate(3, student.getDOB());
            statement.setBoolean(4, student.isGender());
            statement.setString(5, student.getAddress());
            
            // Execute the insert
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Student student) {
        String sql = "UPDATE Student SET Name = ?, DOB = ?, Gender = ?, Address = ? WHERE ID = ?";
        try {
            // Prepare the SQL statement
            statement = connection.prepareStatement(sql);
            
            // Set the parameters
            statement.setString(1, student.getName());
            statement.setDate(2, student.getDOB());
            statement.setBoolean(3, student.isGender());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getID());
            
            // Execute the update
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
        public void delete(String studentID) {
        String sql = "DELETE FROM Student WHERE ID = ?";
        try {
            // Prepare the SQL statement
            statement = connection.prepareStatement(sql);
            
            // Set the parameters
            statement.setString(1, studentID);
            
            // Execute the delete
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
