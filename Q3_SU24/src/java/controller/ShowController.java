/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ExecutionDAO;
import dal.ItemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.ExecutionItems;
import model.Executions;

public class ShowController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ExecutionDAO exDAO = new ExecutionDAO();
        ItemDAO itemDAO = new ItemDAO();
        List<Executions> listEx = exDAO.findAll();
        List<ExecutionItems> listItem = itemDAO.findAll();

        session.setAttribute("listEx", listEx);
        session.setAttribute("listItem", listItem);

        request.getRequestDispatcher("show.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String executionId = request.getParameter("executionId");
        ExecutionDAO exDAO = new ExecutionDAO();
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.delete(executionId);
        exDAO.delete(executionId);
        response.sendRedirect("show");
    }

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

}
