/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import java.sql.*;

/**
 *
 * @author stephhoang
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAll() {

        connection = getConnection();

        List<Category> list = new ArrayList<>();

        String sql = "SELECT * FROM Category";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Category c = new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("describe")
                );
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Category c) {

        connection = getConnection();

        String sql = "INSERT INTO [dbo].[Category]\n"
                + "( \n"
                + "[id], [name], [describe]\n"
                + ")\n"
                + "VALUES\n"
                + "( \n"
                + " ?, ?, ?\n"
                + ")";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // set parameter
            statement.setObject(1, c.getId());
            statement.setObject(2, c.getName());
            statement.setObject(3, c.getDescribe());

            // thuc thi cau lenh
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existedCategory(String id) {
        for (Category category : getAll()) {
            if (category.getId() == Integer.parseInt(id)) {
                return true;
            }
        }
        return false;
    }

    public void delete(String id) {
        connection = getConnection();

        String sql = "DELETE FROM [dbo].[Category]\n"
                + "WHERE [id] = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setObject(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Category getCategoryById(String id) {
        connection = getConnection();

        String sql = "SELECT * FROM [dbo].[Category]\n"
                + "WHERE [id] = ?";

        Category c = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setObject(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                c = new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("describe")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public void update(Category c) {
        connection = getConnection();

        String sql = "UPDATE [dbo].[Category]\n"
                + "SET\n"
                + "    [name] = ?,\n"
                + "    [describe] = ?\n"
                + "WHERE [id] = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setObject(1, c.getName());
            statement.setObject(2, c.getDescribe());
            statement.setObject(3, c.getId());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
