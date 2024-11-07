/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Role;

/**
 *
 * @author stephhoang
 */
public class RoleDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Role]";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Role role = new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return roles;
    }

}
