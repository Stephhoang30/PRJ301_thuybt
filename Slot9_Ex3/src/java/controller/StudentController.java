/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author stephhoang
 */
public class StudentController extends HttpServlet {

    StudentDAO sDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> listMajor = sDAO.getMajor();
        
        List<Student> listStudentByMajor = sDAO.getAll();


        request.setAttribute("listMajor", listMajor);
        request.setAttribute("listStudentByMajor", listStudentByMajor);
        request.setAttribute("value", "");  

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action") == null
                ? "" : request.getParameter("action");

        switch (action) {
            case "searchByMajor":
                
                String value = request.getParameter("option");
                List<Student> listStudentByMajor = new ArrayList<>();
                if (value == null || value.isEmpty()) {
                    listStudentByMajor = sDAO.getAll();
                } else {
                    listStudentByMajor = sDAO.getAllByMajor(value);
                }

                List<String> listMajor = sDAO.getMajor();

                request.setAttribute("listMajor", listMajor);
                request.setAttribute("listStudentByMajor", listStudentByMajor);
                request.setAttribute("value", value);

                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            default:
                throw new AssertionError();
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
