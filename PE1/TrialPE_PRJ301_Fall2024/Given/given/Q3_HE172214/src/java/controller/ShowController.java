/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.InstructorDAO;
import dal.SubjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Instructor;
import model.Subject;

/**
 *
 * @author stephhoang
 */
public class ShowController extends HttpServlet {

    // new object DAO
    InstructorDAO iDAO = new InstructorDAO();
    SubjectDAO sDAO = new SubjectDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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

        // get list      
        List<Subject> listSubjects = sDAO.getAll();
        List<Instructor> listInstructors = listInstructors = iDAO.getAll();

        // set and forward
        request.setAttribute("listInstructors", listInstructors);
        request.setAttribute("listSubjects", listSubjects);
        request.getRequestDispatcher("show.jsp").forward(request, response);
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
                ? "" : request.getParameter("action");

        switch (action) {
            case "searchBySubID":

                // get param
                String subjectID = request.getParameter("subjectID");
                List<Instructor> listInstructors = new ArrayList<>();
                if (subjectID == null || subjectID.isEmpty()) {
                    listInstructors = iDAO.getAll();
                } else {
                    listInstructors = iDAO.getInsBySub(subjectID);
                }
                 
                List<Subject> listSubjects = sDAO.getAll();
                // set and forward
                request.setAttribute("subjectID", subjectID);
                request.setAttribute("listInstructors", listInstructors);
                request.setAttribute("listSubjects", listSubjects);
                request.getRequestDispatcher("show.jsp").forward(request, response);

                break;

            default:
                response.sendRedirect("show");
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
