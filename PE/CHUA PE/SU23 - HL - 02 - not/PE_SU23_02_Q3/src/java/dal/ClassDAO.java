/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Classes;

/**
 *
 * @author ADMIN
 */
public class ClassDAO extends GenericDAO<Classes>{

    @Override
    public List<Classes> findAll() {
        return queryGenericDAO();
    }

    @Override
    public int insert(Classes t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        for (Classes arg : new ClassDAO().findAll()) {
            System.out.println(arg);
        }
    }
    
}
