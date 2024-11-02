/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.LinkedHashMap;
import java.util.List;
import model.Executions;

/**
 *
 * @author ADMIN
 */
public class ExecutionDAO extends GenericDAO<Executions> {

    @Override
    public List<Executions> findAll() {
        return queryGenericDAO();
    }

    @Override
    public int insert(Executions t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        System.out.println(new ExecutionDAO().findAll());
    }

    public void delete(String executionId) {
        String sql = "DELETE FROM [dbo].[Executions]\n"
                + "      WHERE ExecutionID = ?";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("1", executionId);
        deleteGenericDAO(sql);
    }

}
