/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.List;
import model.Coaches;

/**
 *
 * @author stephhoang
 */
public class CoachDAO extends GenericDAO<Coaches> {

    @Override
    public List<Coaches> findAll() {
        return queryGenericDAO(Coaches.class);
    }

    @Override
    public int insert(Coaches t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        for (Coaches coaches : new CoachDAO().findAll()) {
            System.out.println(coaches);
        }
    }

    public Coaches findByID(String id) {
        String sql = "SELECT * FROM [dbo].[Coaches]\n"
                + "WHERE Coaches.CoachID = ?";

        parameterMap = new LinkedHashMap<>();
        parameterMap.put("1", id);

        List<Coaches> list = queryGenericDAO(Coaches.class, sql, parameterMap);
        return list.isEmpty() ? null : list.get(0);
    }

    public void deleteByID(String id) {
        String sql = "DELETE FROM [dbo].[Coaches]\n"
                + "WHERE Coaches.CoachID = ?";
        
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("1", id);
        
        deleteGenericDAO(sql, parameterMap);
    }
}
