/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.LinkedHashMap;
import java.util.List;
import model.ExecutionItems;

/**
 *
 * @author ADMIN
 */
public class ItemDAO extends GenericDAO<ExecutionItems> {

    @Override
    public List<ExecutionItems> findAll() {
        return queryGenericDAO();
    }

    @Override
    public int insert(ExecutionItems t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        System.out.println(new ItemDAO().findAll());
    }

    public void delete(String executionId) {
        String sql = "DELETE FROM [dbo].[ExecutionItems]\n"
                + "      WHERE ExecutionID = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("1", executionId);
        deleteGenericDAO(sql);
    }
}
