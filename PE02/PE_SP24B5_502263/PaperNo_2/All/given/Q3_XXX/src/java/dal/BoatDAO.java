/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Boats;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author stephhoang
 */
public class BoatDAO extends DBContext {

    public List<Boats> getBoats(Integer depID) {
        List<Boats> listBoats = new ArrayList<>();
        try {
            String sql = "SELECT *\n"
                    + "FROM Boats B\n"
                    + "JOIN DepartPlaces D on B.DepartPlaceID = D.DepartPlaceID\n"
                    + "JOIN Tickets T on B.TicketID = T.TicketID\n";
            if (depID != null && depID > 0) {
                sql += " WHERE B.DepartPlaceID = " + depID;
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Boats boat = new Boats(
                        resultSet.getString("BoatID"),
                        resultSet.getString("BoatName"),
                        resultSet.getString("DepartPlaceName"),
                        resultSet.getString("TicketName"),
                        resultSet.getInt("Seat"),
                        resultSet.getInt("Booked")
                );

                listBoats.add(boat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBoats;
    }

}
