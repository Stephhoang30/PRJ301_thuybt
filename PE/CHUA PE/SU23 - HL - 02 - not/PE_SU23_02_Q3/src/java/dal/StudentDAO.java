/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.LinkedHashMap;
import java.util.List;
import model.Students;

/**
 *
 * @author ADMIN
 */
public class StudentDAO extends GenericDAO<Students> {

    @Override
    public List<Students> findAll() {
        return queryGenericDAO();
    }

    @Override
    public int insert(Students t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        for (Students students : new StudentDAO().findAll()) {
            System.out.println(students);
        }
    }

    public void updateStudent(Students st, String oldId) {
        String sql = "UPDATE [dbo].[Students]\n"
                + "   SET [StudentID] = ?\n"
                + "      ,[StudentName] = ?\n"
                + "      ,[BirthDate] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[ClassID] = ?\n"
                + " WHERE [StudentID] = ? ";
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("1", st.getStudentID());
        parameterMap.put("2", st.getStudentName());
        parameterMap.put("3", st.getBirthDate());
        parameterMap.put("4", st.isGender());
        parameterMap.put("5", st.getClassID());
        parameterMap.put("6", oldId);
        updateGenericDAO(sql);
    }

}
