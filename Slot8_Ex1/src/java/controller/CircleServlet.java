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
import java.text.DecimalFormat;

/**
 *
 * @author stephhoang
 */
public class CircleServlet extends HttpServlet {

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
        doPost(request, response);
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
        String radiusStr = request.getParameter("radius");
        String msg = "";
        double area = 0;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Circle3Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Circle Area Calculation 2 </h2>");
            if (radiusStr == null || radiusStr.trim().isEmpty()) {
                msg = "<p style='color:red;'> Error: PLease enter a radius value. </p>";
                out.println(msg);
            } else {
                try {
                    double radius = Double.parseDouble(radiusStr);
                    if (radius < 0) {
                        msg = "<p style='color:red;'> Error: Radius cannot be negative. Please enter a positive value. </p>";
                        out.println(msg);
                    } else {
                        area = Math.PI * radius * radius;
                        DecimalFormat df = new DecimalFormat("#.##");
                        String formattedArea = df.format(area);
                        out.println("<p> Area of the circle with radius " + radius + " is: " + formattedArea + "</p>");
                    }
                } catch (NumberFormatException e) {
                    msg = "<p style='color:red;'> Error: Invalid input. Please enter a valid number. </p>";
                    out.println(msg);
                }
            }           
            out.println("<form action='cal' method='POST'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
