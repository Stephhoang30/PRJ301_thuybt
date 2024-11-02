/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.DBContext;
import java.sql.*;
import model.Account;

/**
 *
 * @author stephhoang
 */
public class AccountDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public Account checkUsernameAndPassword(Account account) {
        String sql = "SELECT * FROM Account WHERE username = ? AND [password] = ?";

        try {
            // Prepare the SQL statement
            statement = connection.prepareStatement(sql);

            // Set the parameters
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());

            // Execute the query
            resultSet = statement.executeQuery();

            // If a matching account is found, populate and return the Account object
            if (resultSet.next()) {
                Account foundAccount = new Account();
                foundAccount.setId(resultSet.getInt("id"));
                foundAccount.setUsername(resultSet.getString("username"));
                foundAccount.setPassword(resultSet.getString("password"));
                foundAccount.setEmail(resultSet.getString("email"));
                foundAccount.setAddress(resultSet.getString("address"));
                foundAccount.setRoleId(resultSet.getInt("roleId"));
                return foundAccount;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return null;
    }

    public boolean checkUsername(Account a) {
        String sql = "SELECT * \n"
                + "FROM Account \n"
                + "WHERE username = ?";

        try {
            statement = connection.prepareStatement(sql);

            statement.setObject(1, a.getUsername());

            resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void insert(Account a) {
        String sql = "INSERT INTO Account (username, password, email, address, roleId) VALUES (?, ?, ?, ?, ?)";

        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, a.getUsername());
            statement.setObject(2, a.getPassword());
            statement.setObject(3, a.getEmail());
            statement.setObject(4, a.getAddress());
            statement.setObject(5, a.getRoleId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
