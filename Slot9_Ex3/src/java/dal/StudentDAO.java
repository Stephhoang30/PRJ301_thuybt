/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
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
        List<Student> listStudent = new ArrayList<>();
        
        String sql = "SELECT * FROM Student";
        try {
            statement = connection.prepareStatement(sql);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Student s = new Student(
                        resultSet.getString("RollNo"),
                        resultSet.getString("Major"),
                        resultSet.getString("FullName"),
                        resultSet.getString("City"),
                        resultSet.getBoolean("Gender")
                );
                listStudent.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStudent;
    }
    
    public List<String> getMajor() {
        List<String> listMajor = new ArrayList<>();
        
        String sql = "SELECT DISTINCT Major FROM Student";        
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                listMajor.add(resultSet.getString("Major"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return listMajor;
    }
    
    public List<Student> getAllByMajor(String value) {
        List<Student> listStudent = new ArrayList<>();
        
        String sql = "SELECT * FROM Student WHERE Major LIKE ?";
        try {
            statement = connection.prepareStatement(sql);
            
            statement.setObject(1, "%" + value + "%");
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Student s = new Student(
                        resultSet.getString("RollNo"),
                        resultSet.getString("Major"),
                        resultSet.getString("FullName"),
                        resultSet.getString("City"),
                        resultSet.getBoolean("Gender")
                );
                listStudent.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStudent;
    }
    
    public void addStudent(Student student) {
        
        String sql = "INSERT INTO Student (RollNo, Major, FullName, City, Gender) VALUES (?, ?, ?, ?, ?)";
        try {
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getRollNo());
            statement.setString(2, student.getMajor());
            statement.setString(3, student.getFullName());
            statement.setString(4, student.getCity());
            statement.setBoolean(5, student.isGender());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        for (Student student : new StudentDAO().getAllByMajor("Business")) {
            System.out.println(student);
        }
    }
    
}
