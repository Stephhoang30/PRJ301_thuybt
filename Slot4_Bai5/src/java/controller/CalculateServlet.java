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
public class CalculateServlet extends HttpServlet {

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
            out.println("<title>Servlet CalculateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculateServlet at " + request.getContextPath() + "</h1>");
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
        try {
            double first = Double.parseDouble(request.getParameter("first"));
            double second = Double.parseDouble(request.getParameter("second"));
            String[] tinhs = request.getParameterValues("tinh");
            double result = 0;
            if (tinhs != null) {
                for (String tinh : tinhs) {
                    if (tinh.equals("cong")) {
                        result = first + second;
                        break;
                    } else if (tinh.equals("tru")) {
                        result = first - second;
                        break;
                    } else if (tinh.equals("nhan")) {
                        result = first * second;
                    } else if (tinh.equals("chia")) {
                        if (second == 0) {
                            throw new NumberFormatException("Second number != 0");
                        } else {
                            result = first / second;
                        }
                    }
                }
            } else {
                response.getWriter().println("No option selected!!");
            }

            response.getWriter().printf("Kết quả: %.2f", result);

        } 
        catch (NumberFormatException e) {
            response.getWriter().println(e.getMessage());
        }
        catch (Exception e) {
            response.getWriter().println("Error!!");
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
