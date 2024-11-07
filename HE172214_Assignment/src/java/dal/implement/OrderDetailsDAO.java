/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.OrderDetails;
/**
 *
 * @author stephhoang
 */
public class OrderDetailsDAO extends DBContext {
    protected PreparedStatement statement;
    protected ResultSet resultSet;
    
    public List<OrderDetails> findAll() {
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[OrderDetails]";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(
                    resultSet.getInt("id"),
                    resultSet.getInt("quantity"),
                    resultSet.getInt("productId"),
                    resultSet.getInt("orderId")
                );
                orderDetailsList.add(orderDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return orderDetailsList;
    }
    
    public int insert(OrderDetails orderDetails) {
        String sql = "INSERT INTO [dbo].[OrderDetails] ([quantity], [productId], [orderId]) VALUES (?, ?, ?)";
        int result = 0;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderDetails.getQuantity());
            statement.setInt(2, orderDetails.getProductId());
            statement.setInt(3, orderDetails.getOrderId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return result;
    }
}
