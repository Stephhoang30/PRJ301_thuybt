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

    public List<Product> findByCategory(String categoryId, int page) {
        List<Product> products = new ArrayList<>();
        int recordsPerPage = 12;
        String sql = "SELECT * FROM Product WHERE categoryId = ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, categoryId);
            statement.setInt(2, (page - 1) * recordsPerPage);
            statement.setInt(3, recordsPerPage);
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

    public List<Product> findByName(String keyword, int page) {
        List<Product> products = new ArrayList<>();
        int recordsPerPage = 12;
        String sql = "SELECT * FROM Product WHERE name LIKE ? ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            statement.setInt(2, (page - 1) * recordsPerPage);
            statement.setInt(3, recordsPerPage);
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

    public void deleteById(int id) {
        String sql = "DELETE FROM Product WHERE id = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Product product) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [name] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[categoryId] = ?\n"
                + " WHERE id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getImage());
            statement.setInt(3, product.getQuantity());
            statement.setFloat(4, product.getPrice());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCategoryId());
            statement.setInt(7, product.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int findTotalRecordByCategory(String categoryId) {
        String sql = "SELECT count(*) FROM Product WHERE categoryId = ?";
        int count = 0;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, categoryId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int findTotalRecordByName(String keyword) {
        String sql = "SELECT count(*) FROM Product WHERE name LIKE ?";
        int count = 0;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int findTotalRecord() {
        String sql = "SELECT count(*) FROM Product";
        int count = 0;

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public List<Product> findByPage(int page) {
    List<Product> products = new ArrayList<>();
    int recordsPerPage = 12; 
    String sql = "SELECT * FROM Product ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

    try {
        statement = connection.prepareStatement(sql);
        statement.setInt(1, (page - 1) * recordsPerPage);
        statement.setInt(2, recordsPerPage);
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

}
