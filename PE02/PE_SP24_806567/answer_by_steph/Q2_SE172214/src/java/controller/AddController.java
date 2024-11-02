/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Player;

/**
 *
 * @author stephhoang
 */
public class AddController extends HttpServlet {

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
            out.println("<title>Servlet AddController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        HttpSession session = request.getSession();
        List<Player> list = (List<Player>) session.getAttribute("list");

        // kiem tra xem tren session co list hay chua, chua co thi tao list moi
        if (list == null) {
            list = new ArrayList<>();
        }

        try {
            // get ve thong tin
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String position = request.getParameter("position");
            int salary = Integer.parseInt(request.getParameter("salary"));

            if (salary <= 0) {
                request.setAttribute("code", code);
                request.setAttribute("name", name);
                request.setAttribute("position", position);
                request.setAttribute("salary", salary);

                throw new NumberFormatException();
            }

            for (Player player : list) {
                if (player.getCode().equalsIgnoreCase(code)) {
                    request.setAttribute("code", code);
                    request.setAttribute("name", name);
                    request.setAttribute("position", position);
                    request.setAttribute("salary", salary);
                    throw new IllegalArgumentException();
                }
            }

            // tao doi tuong player
            Player player = new Player(code, name, position, salary);

            // them vao trong list
            list.add(player);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "You must input an integer >0 for salary!");
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Code existed!");
        } finally {

            session.setAttribute("list", list);
            request.getRequestDispatcher("MyExam.jsp").forward(request, response);
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
