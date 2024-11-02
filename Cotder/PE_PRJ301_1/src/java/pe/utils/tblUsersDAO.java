/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.utils;

import java.util.List;
import pe.entity.tblUsers;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author stephhoang
 */
public class tblUsersDAO {

    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<tblUsers> findAll() {
        List<tblUsers> list = new ArrayList<>();
        try {
            // tao ra ket noi
            connection = DBUtils.getConnection();

            // cau lenh sql
            String sql = "SELECT * FROM [dbo].[tblUsers]";

            // prepared Statement
            statement = connection.prepareStatement(sql);

            // thuc thi cau lenh
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String userID = resultSet.getString("userID");
                String password = resultSet.getString("password");

                tblUsers user = new tblUsers();

                user.setUserID(userID);
                user.setPassword(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public tblUsers checkUandP(String userID, String password) {
        List<tblUsers> userList = new ArrayList<>();
        try {
            // tao ra ket noi 
            connection = DBUtils.getConnection();

            // cau lenh sql
            String sql = "SELECT * FROM [dbo].[tblUsers]\n"
                    + "WHERE userID = ? AND [password] = ? ";

            // prepared statement
            statement = connection.prepareStatement(sql);

            // set parameter
            statement.setObject(1, userID);
            statement.setObject(2, password);

            // thuc thi cau lenh
            resultSet = statement.executeQuery();

            // tra ve ket qua
            if (resultSet.next()) {
                String userID_Found = resultSet.getString("userID").trim();
                String fullName_Found = resultSet.getString("fullName").trim();
                String password_Found = resultSet.getString("password").trim();
                String roleID_Found = resultSet.getString("roleID").trim();
                boolean status_Found = resultSet.getBoolean("status");

                tblUsers user = new tblUsers();
                user.setUserID(userID_Found);
                user.setFullName(fullName_Found);
                user.setPassword(password_Found);
                user.setRoleID(roleID_Found);
                user.setStatus(status_Found);
                
                userList.add(user);
                return userList.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
