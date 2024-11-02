/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author stephhoang
 */
public class AccountDAO extends DBContext {
    
    public List<Account> findAll() throws SQLException {
        
        List<Account> listFound = new ArrayList<>();

        // connect with DB
        connection = getConnection();

        // chuẩn bị câu lệnh SQL
        String sql = "SELECT *\n"
                + "FROM Account";
        
        try {
            // Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);

            //- Set parameter ( optional )
            // Thực thi câu lệnh
            resultSet = statement.executeQuery();
            //  trả về kết quả

            while (resultSet.next()) {
                
                String username = resultSet.getString("username").trim();
                String password = resultSet.getString("password").trim();
                
                Account account = new Account(username, password);
                
                listFound.add(account);
                
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return listFound;
        
    }
    
    public Account findByUsernamePassword(String username, String password) throws SQLException {

        // connect with DB
        connection = getConnection();

        // chuẩn bị câu lệnh SQL
        String sql = "SELECT *\n"
                + "FROM Account\n"
                + "WHERE username=? AND [password]=? ";
        
        try {
            
            // Tạo đối tượng PrepareStatement
            
            statement = connection.prepareStatement(sql);

            //- Set parameter ( optional )
            
            statement.setObject(1, username);
            statement.setObject(2, password);

            // Thực thi câu lệnh
            
            resultSet = statement.executeQuery();

            //  trả về kết quả
            
            if (resultSet.next()) {
                
                String username_Found = resultSet.getString("username").trim();
                String password_Found = resultSet.getString("password").trim();
                
                Account account = new Account(username, password);
                
                return account;
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
        
    }
    
    public static void main(String[] args) {
        try {
            //        try {
//            for (Account account : new AccountDAO().findAll()) {
//                System.out.println(account);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

            System.out.println(new AccountDAO().findByUsernamePassword("thanh", "123"));
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
