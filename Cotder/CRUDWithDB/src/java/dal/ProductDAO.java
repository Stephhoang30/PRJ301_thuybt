/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import java.sql.*;

/**
 *
 * @author stephhoang
 */
public class ProductDAO extends DBContext {

    public List<Product> findAll() {

        List<Product> listFound = new ArrayList<>();

        try {
            // connect with DB
            connection = getConnection();

            // chuan bi cau lenh SQL
            String sql = "SELECT *\n"
                    + "FROM Product";

            // tao doi tuong PreparedStatement
            statement = connection.prepareStatement(sql);

            // thuc thi cau lenh
            resultSet = statement.executeQuery();

            // tra ve ket qua
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name").trim();
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");

                Product product = new Product(id, name, quantity, price);

                listFound.add(product);

            }
            return listFound;
        } catch (NumberFormatException | SQLException e) {
            System.err.println(e.getMessage());

        }
        return null;
    }

    public static void main(String[] args) {
        for (Product product : new ProductDAO().findAll()) {
            System.out.println(product);
        }
    }

    public List<Product> findByName(String keyword) {

        List<Product> listFound = new ArrayList<>();

        // connect with DB
        connection = getConnection();

        // chuan bi cau lenh SQL
        String sql = "SELECT *\n"
                + "FROM Product\n"
                + "WHERE name LIKE ? ";
        try {
            // tao doi tuong PreparedStatement
            statement = connection.prepareStatement(sql);

            // set parameter
            statement.setString(1, "%" + keyword + "%");

            // thuc thi cau lenh
            resultSet = statement.executeQuery();

            // tra ve ket qua
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name").trim();
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");

                Product product = new Product(id, name, quantity, price);

                listFound.add(product);

            }
            return listFound;
        } catch (NumberFormatException | SQLException e) {
            System.err.println(e.getMessage());

        }
        return null;
    }

    public void insert(Product product) {
        // ket noi voi DB
        connection = getConnection();

        // tao cau lenh SQL
        String sql = "INSERT INTO [dbo].[Product]([name], [quantity], [price])\n"
                + "VALUES (?, ?, ?)";
        try {
            // tao doi tuong PreparedStatement ( them generated key vao tham so thu 2 )
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // set parameter
            statement.setObject(1, product.getName());
            statement.setObject(2, product.getQuantity());
            statement.setObject(3, product.getPrice());

            // thuc thi cau lenh
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // tra ve ket qua (optional)
    }

    public void update(Product product) {
        // ket noi voi DB
        connection = getConnection();

        // tao cau lenh SQL
        String sql = "UPDATE [dbo].[Product]\n"
                + "SET\n"
                + "    [name] = ?,\n"
                + "    [quantity] = ?,\n"
                + "    [price] = ?   \n"
                + "WHERE [id] = ?";
        try {
            // tao doi tuong PreparedStatement ( them generated key vao tham so thu 2 )
            statement = connection.prepareStatement(sql);

            // set parameter
            statement.setObject(1, product.getName());
            statement.setObject(2, product.getQuantity());
            statement.setObject(3, product.getPrice());
            statement.setObject(4, product.getId());

            // thuc thi cau lenh
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteById(Product product) {
        // ket noi voi DB
        connection = getConnection();

        // tao cau lenh SQL
        String sql = "DELETE FROM [dbo].[Product]\n"
                + "WHERE [id] = ?";
        try {
            // tao doi tuong PreparedStatement ( them generated key vao tham so thu 2 )
            statement = connection.prepareStatement(sql);

            // set parameter
            statement.setObject(1, product.getId());

            // thuc thi cau lenh
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

}
