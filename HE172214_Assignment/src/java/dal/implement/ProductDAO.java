/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.DBContext;
import java.util.List;
import model.Product;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author stephhoang
 */
public class ProductDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product findById(int productId) {
        String sql = "SELECT * FROM Product WHERE id = ?";
        Product product = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = extractProductFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public List<Product> findByCategory(String categoryId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE categoryId = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, categoryId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> findByName(String keyword) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE name LIKE ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    private Product extractProductFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String image = resultSet.getString("image");
        int quantity = resultSet.getInt("quantity");
        float price = resultSet.getFloat("price");
        String description = resultSet.getString("description");
        int categoryId = resultSet.getInt("categoryId");

        return new Product(id, name, image, quantity, price, description, categoryId);
    }

    public void insert(Product p) {
        String sql = "INSERT INTO Product (name, image, quantity, price, description, categoryId) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, p.getName());
            statement.setString(2, p.getImage());
            statement.setInt(3, p.getQuantity());
            statement.setFloat(4, p.getPrice());
            statement.setString(5, p.getDescription());
            statement.setInt(6, p.getCategoryId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
