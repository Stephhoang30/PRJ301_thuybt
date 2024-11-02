/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.StudentDAO;
import dal.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Students;
import model.Subjects;

/**
 *
 * @author stephhoang
 */
public class ListServlet extends HttpServlet {

    SubjectDAO sbjDao = new SubjectDAO();
    StudentDAO stuDAO = new StudentDAO();
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

        // get ve tat ca cac subjects
        List<Subjects> listSbj = sbjDao.findAll();
        
        // get ve tat ca student by sbj at first
        List<Students> listStudent = new ArrayList<>();       
        if(!listSbj.isEmpty()){
            listStudent = stuDAO.findBySBID(listSbj.get(0).getSubjectID());
        }

        // set vao trong session 
        HttpSession session = request.getSession();
        session.setAttribute("listSubject", listSbj);
        session.setAttribute("listStudent", listStudent);

        // chuyen sang trang index.jsp
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
        
        String action = request.getParameter("action") == null
                ? ""
                : request.getParameter("action");
        
        switch (action) {
            case "searchBySBID":
                // get ve ID cua subject
                String subjectID = request.getParameter("subjectID");
                
                // tim kiem cac student by subject id
                List<Students> listStudent = stuDAO.findBySBID(subjectID);
                
                // set list vao ben trong session
                HttpSession session = request.getSession();
                session.setAttribute("listStudent", listStudent);
                request.setAttribute("subjectID", subjectID);
                // chuyen sang trang index.jsp
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect("list");
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
