/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import java.sql.*;

/**
 *
 * @author stephhoang
 */
public class OrderDAO extends DBContext{
    protected PreparedStatement statement;
    protected ResultSet resultSet;
    
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[Order]";
        
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Order order = new Order(
                    resultSet.getInt("id"),
                    resultSet.getInt("amount"),
                    resultSet.getInt("accountId"),
                    resultSet.getTimestamp("createAt")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return orders;
    }
    
    
    public int insert(Order order) {
        String sql = "INSERT INTO [dbo].[Order] ([amount], [accountId], [createAt]) VALUES (?, ?, ?)";
        int result = 0;
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getAmount());
            statement.setInt(2, order.getAccountId());
            statement.setTimestamp(3, order.getCreateAt());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return result;
    }
}
