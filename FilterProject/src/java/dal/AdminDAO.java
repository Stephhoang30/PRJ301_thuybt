/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
import model.Admin;
/**
 *
 * @author stephhoang
 */
public class AdminDAO extends DBContext{
    
    public Admin check(String username, String password) {
        String sql = "SELECT [Username]\n"
                + " ,[Password]\n"
                + " ,[role]\n"
                + " FROM [dbo].[Admin]\n"
                + " where [Username]=? and [Password]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("role"));
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
