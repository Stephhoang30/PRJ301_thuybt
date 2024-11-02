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

/**
 *
 * @author stephhoang
 */
public class SumServlet extends HttpServlet {

    static final String msg1 = "You must input an integer > 5";
    static final String msg2 = "You must choose an option";

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
            out.println("<title>Servlet SumServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SumServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SumServlet</title>");
            out.println("</head>");
            out.println("<body>");

            try {

                int n = Integer.parseInt(request.getParameter("n"));
                String sum = request.getParameter("sum");

                if (n <= 5) {
                    out.println("<h1> " + msg1 + "</h1>");
                } else if (sum == null) {
                    out.println("<h1> " + msg2 + "</h1>");
                } else if (sum.equals("odd")) {
                    out.println("<h1> " + tinhTongSoLe(n) + "</h1>");
                } else if (sum.equals("even")) {
                    out.println("<h1> " + tinhTongSoChan(n) + "</h1>");
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    public static int tinhTongSoLe(int upto) {
        int sum = 0;
        for (int number = 1; number <= upto; number++) {
            if (kiemTraSoLe(number)) {
                sum += number;
            }
        }
        return sum;
    }

    public static int tinhTongSoChan(int upto) {
        int sum = 0;
        for (int i = 0; i <= upto; i++) {
            if (kiemTraSoChan(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public static boolean kiemTraSoLe(int number) {
        return number % 2 != 0;
    }

    public static boolean kiemTraSoChan(int number) {
        return number % 2 == 0;
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
