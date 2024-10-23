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

    public boolean checkUsernameAndPassword(Account account) {
        String sql = "SELECT * \n"
                + "FROM Account \n"
                + "WHERE username = ? AND [password] = ?";

        try {
            statement = connection.prepareStatement(sql);

            statement.setObject(1, account.getUsername());
            statement.setObject(2, account.getPassword());

            resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
