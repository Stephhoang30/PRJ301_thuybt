/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Exe;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Tra Pham
 */
public class ExeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Exe> getExe(String typeName, String typeIndex) {
        ArrayList<Exe> list = new ArrayList<>();
        String query = "select * from Executions e join Types t\n"
                + "on t.TypeID = e.TypeID";
        try {
            if (!(typeName.isEmpty()) && !(typeIndex.isEmpty())) {
//                query = "select * from Executions e join Types t\n"
//                        + "on t.TypeID = e.TypeID order by TypeName "+typeName+" ,SubIndex" +typeIndex;
                query = "select * from Executions e join Types t\n"
                        + "on t.TypeID = e.TypeID order by TypeName "+typeName+", SubIndex "+typeIndex;

            } else if (typeName.isEmpty() && !(typeIndex.isEmpty())) {
                query = "select * from Executions e join Types t\n"
                        + "on t.TypeID = e.TypeID" + " order by SubIndex " + typeIndex;
            } else if (!(typeName.isEmpty()) && typeIndex.isEmpty()) {
                query = "select * from Executions e join Types t\n"
                        + "on t.TypeID = e.TypeID" + " order by TypeName " + typeName;
            } else {
                query = "select * from Executions e join Types t\n"
                        + "on t.TypeID = e.TypeID";
            }

            conn = new DBContext().connection;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Exe(rs.getString("InputString"), rs.getString("Result"),
                        rs.getString("TypeName"), rs.getInt("ExecutionID"), rs.getInt("SubIndex")));
            }
        } catch (Exception e) {
//    public Exe(String , String , String , int , int ) {

        }

        return list;
    }
}
