/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ClassDAO;
import dal.InstructorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Instructor;
import model.Class;
import java.sql.*;

/**
 *
 * @author stephhoang
 */
public class UpdateServlet extends HttpServlet {
    
    InstructorDAO insDAO = new InstructorDAO();
    ClassDAO classDAO = new ClassDAO();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get ve data ins
        List<Instructor> listIns = insDAO.findAll();
        List<Class> listClass = classDAO.findAll();
        
        HttpSession session = request.getSession();
        session.setAttribute("listIns", listIns);
        session.setAttribute("listClass", listClass);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String insID = request.getParameter("code");
            String oldID = request.getParameter("oldID");
            String insName = request.getParameter("name");
            Date bod = Date.valueOf(request.getParameter("dob"));
            boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
            int classID = Integer.parseInt(request.getParameter("classSelect"));
            
            Instructor ins = new Instructor(insID, insName, bod, gender, classID);
            insDAO.updateINS(ins, oldID);
            response.sendRedirect("update");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
