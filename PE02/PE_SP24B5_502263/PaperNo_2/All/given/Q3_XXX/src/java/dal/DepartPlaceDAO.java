/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.DepartPlaces;
import java.sql.*;

/**
 *
 * @author stephhoang
 */
public class DepartPlaceDAO extends DBContext {

    public List<DepartPlaces> getDepartPlaces() {
        List<DepartPlaces> listDe = new ArrayList<>();
        try {

            String sql = "SELECT *\n"
                    + "FROM DepartPlaces";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DepartPlaces de = new DepartPlaces(
                        resultSet.getInt("DepartPlaceID"),
                        resultSet.getString("DepartPlaceName"));

                listDe.add(de);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDe;

    }
}
