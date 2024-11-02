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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stephhoang
 */
public class ExecuteController extends HttpServlet {

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
            out.println("<title>Servlet ExecuteController</title>");
            out.println("</head>");
            out.println("<body>");
            try {
                String n1_raw = request.getParameter("number1");
                String n2_raw = request.getParameter("number2");

                if (n1_raw == null || n1_raw.isBlank() || n2_raw == null || n2_raw.isBlank()) {
                    out.println("<h1>You must input texts</h1>");
                } else {
                    int number1 = Integer.parseInt(n1_raw);
                    int number2 = Integer.parseInt(n2_raw);

                    if (number1 <= 0 || number2 <= 0) {
                        out.println("<h1>You must input an integer > 0</h1>");
                    } else {
                        StringBuilder res = new StringBuilder();
                        for (Integer num : findNLCMs(number1, number2, 3)) {
                            res.append(num).append("\t");
                        }
                        out.println("<h1>" + res.toString().trim() + "</h1>");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.println("</body>");
            out.println("</html>");
        }

    }

    public static List<Integer> findNLCMs(int num1, int num2, int n) {
        int lcm = timBoiSoChungNhoNhat(num1, num2);
        List<Integer> lcmList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lcmList.add(lcm * i);
        }
        return lcmList;
    }

    public static int timBoiSoChungNhoNhat(int a, int b) {
        return Math.abs(a * b) / timUocChungLonNhat(a, b);
    }

    public static int timUocChungLonNhat(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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
