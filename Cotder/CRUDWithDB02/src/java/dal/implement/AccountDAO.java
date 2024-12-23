/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.util.LinkedHashMap;
import java.util.List;
import model.Account;

/**
 *
 * @author stephhoang
 */
public class AccountDAO extends GenericDAO<Account>{

    @Override
    public List<Account> findAll() {
        // dinh nghia ra cau lenh SQL
        String sql = "SELECT * FROM [dbo].[Account]";
        
        // khoi tao moi parameter map (optional)
        
        
        // lay ve du lieu
        List<Account> list = queryGenericDAO(Account.class);
        
        // tra ve du lieu       
        return list;
    }

    public Account findByUsernamePassword(String username, String password) {
        // dinh nghia ra cau lenh SQL
        String sql = "SELECT *\n"
                + "FROM Account\n"
                + "WHERE username=? AND [password]=? ";
        
        // khoi tao moi parameter map (optional)
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("username", username);
        parameterMap.put("password", password);
        
        // lay ve du lieu
        List<Account> list = queryGenericDAO(Account.class, sql, parameterMap);
        
        // tra ve du lieu
        return list.isEmpty() ? null : list.get(0);
        
    }

    
   

    @Override
    public int insert(Account t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     public static void main(String[] args) {
        for (Account account : new AccountDAO().findAll()) {
            System.out.println(account);
        }
    }
    
}
