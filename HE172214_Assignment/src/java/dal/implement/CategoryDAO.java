/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.DBContext;
import java.util.List;
import model.Category;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author stephhoang
 */
public class CategoryDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM Category";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Category category = new Category(id, name);
                categories.add(category);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
