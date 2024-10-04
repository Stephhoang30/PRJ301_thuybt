/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Currency;

/**
 *
 * @author stephhoang
 */
public class CurrencyDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public List<Currency> getAll() {
        List<Currency> list = new ArrayList<>();

        String sql = "SELECT * FROM [dbo].[tblCurrency]";

        try {
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Currency c = new Currency(
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getFloat("rate")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Currency> getByCodeAndName(String code, String name) {
        List<Currency> list = new ArrayList<>();

        String sql = "SELECT * FROM [dbo].[tblCurrency] WHERE 1=1"; // Default condition to append filters

        // Add conditions if code or name is not null/empty
        if (code != null && !code.isEmpty()) {
            sql += " AND code = ?";
        }
        if (name != null && !name.isEmpty()) {
            sql += " AND name = ?";
        }

        try {
            statement = connection.prepareStatement(sql);

            int paramIndex = 1; // To keep track of parameter index
            if (code != null && !code.isEmpty()) {
                statement.setString(paramIndex++, code);
            }
            if (name != null && !name.isEmpty()) {
                statement.setString(paramIndex++, name);
            }

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Currency c = new Currency(
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getFloat("rate")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateCurrency(Currency currency) {
        String sql = "UPDATE tblCurrency SET name=?, description=?, rate=? WHERE code=?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, currency.getName());
            statement.setString(2, currency.getDescription());
            statement.setFloat(3, currency.getRate());
            statement.setString(4, currency.getCode());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Currency getCurrencyByCode(String code) {

        String sql = "SELECT * FROM tblCurrency WHERE code = ?";

        try {
            
            statement = connection.prepareStatement(sql);
            statement.setString(1, code);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return new Currency(
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getFloat("rate")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
