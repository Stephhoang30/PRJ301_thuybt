/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Admin;
import java.sql.*;

/**
 *
 * @author stephhoang
 */
public class AdminDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public Admin check(String username, String password) {
        String sql = "SELECT *\n"
                + "FROM Admin\n"
                + "WHERE Username = ? AND [Password] = ?";
        try {
            // Prepare the statement
            statement = connection.prepareStatement(sql);

            // Set the parameters
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute the query
            resultSet = statement.executeQuery();

            // If a record is found, return the Admin object
            if (resultSet.next()) {
                Admin admin = new Admin();
                admin.setUsername(resultSet.getString("Username"));
                admin.setPassword(resultSet.getString("Password"));
                return admin;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Admin a) {
        String sql = "INSERT INTO Admin (Username, [Password]) VALUES (?, ?)";
        try {
            // Prepare the statement
            statement = connection.prepareStatement(sql);

            // Set the parameters
            statement.setString(1, a.getUsername());
            statement.setString(2, a.getPassword());

            // Execute the insert
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean checkIfExists(String username) {
    String sql = "SELECT * FROM Admin WHERE Username = ?";
    try {
        // Prepare the statement
        statement = connection.prepareStatement(sql);

        // Set the parameter
        statement.setString(1, username);

        // Execute the query
        resultSet = statement.executeQuery();

        // If a record is found, the username exists
        return resultSet.next();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    
}
