/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author stephhoang
 */
public class ProductDAO extends DBContext {

    public List<Product> getAll() {

        connection = getConnection();

        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM Product";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product c = new Product(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("price"),
                        resultSet.getDate("releaseDate"),
                        resultSet.getString("describe"),
                        resultSet.getString("image"),
                        resultSet.getInt("cid")
                );
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Product p) {

        connection = getConnection();

        String sql = "INSERT INTO [dbo].[Product] (id, name, quantity, price, "
                + "releaseDate, describe, image, cid) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            // set parameter
            statement.setObject(1, p.getId());
            statement.setObject(2, p.getName());
            statement.setObject(3, p.getQuantity());
            statement.setObject(4, p.getPrice());
            statement.setObject(5, p.getReleaseDate());
            statement.setObject(6, p.getDescribe());
            statement.setObject(7, p.getImage());
            statement.setObject(8, p.getCid());

            // thuc thi cau lenh
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existedProduct(String id) {
        for (Product product : getAll()) {
            if (product.getId().trim().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void delete(String id) {
        connection = getConnection();

        String sql = "DELETE FROM [dbo].[Product] WHERE Product.id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setObject(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(String id) {
        connection = getConnection();

        String sql = "SELECT * FROM [dbo].[Product]\n"
                + "WHERE Product.[id] = ?";

        Product p = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setObject(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                p = new Product(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("price"),
                        resultSet.getDate("releaseDate"),
                        resultSet.getString("describe"),
                        resultSet.getString("image"),
                        resultSet.getInt("cid")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    public void update(Product p) {
        connection = getConnection();

        String sql = "UPDATE [dbo].[Product]\n"
                + "SET\n"
                + "    [name] = ?,\n"
                + "    [quantity] = ?,\n"
                + "    [price] = ?,\n"
                + "    [releaseDate] = ?,\n"
                + "    [describe] = ?,\n"
                + "    [image] = ?,\n"
                + "    [cid] = ?\n"
                + "WHERE [id] = ?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            // set parameter      
            statement.setObject(1, p.getName());
            statement.setObject(2, p.getQuantity());
            statement.setObject(3, p.getPrice());
            statement.setObject(4, p.getReleaseDate());
            statement.setObject(5, p.getDescribe());
            statement.setObject(6, p.getImage());
            statement.setObject(7, p.getCid());
            statement.setObject(8, p.getId());

            // thuc thi cau lenh
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Product> findByName(String keyword) {

        List<Product> list = new ArrayList<>();

        Product p = null;
        
        // connect with DB
        connection = getConnection();

        // chuan bi cau lenh SQL
        String sql = "SELECT *\n"
                + "FROM [dbo].[Product]\n"
                + "WHERE name LIKE ? ";
        try {
            // tao doi tuong PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // set parameter
            statement.setString(1, "%" + keyword + "%");

            // thuc thi cau lenh
            ResultSet resultSet = statement.executeQuery();

            // tra ve ket qua
            while (resultSet.next()) {
                p = new Product(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("price"),
                        resultSet.getDate("releaseDate"),
                        resultSet.getString("describe"),
                        resultSet.getString("image"),
                        resultSet.getInt("cid")
                );
                
                list.add(p);
            }
            
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public List<Product> findByCateID(String cateId) {

        List<Product> list = new ArrayList<>();

        Product p = null;
        
        // connect with DB
        connection = getConnection();

        // chuan bi cau lenh SQL
        String sql = "SELECT * FROM Product WHERE [Product].[cid] = ?";
        try {
            // tao doi tuong PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // set parameter
            statement.setString(1, cateId);

            // thuc thi cau lenh
            ResultSet resultSet = statement.executeQuery();

            // tra ve ket qua
            while (resultSet.next()) {
                p = new Product(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("quantity"),
                        resultSet.getFloat("price"),
                        resultSet.getDate("releaseDate"),
                        resultSet.getString("describe"),
                        resultSet.getString("image"),
                        resultSet.getInt("cid")
                );
                
                list.add(p);
            }
            
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
