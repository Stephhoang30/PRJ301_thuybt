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
public class CheckServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet CheckServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String numberStr = request.getParameter("number");
        String msgChan = "";
        String msgLe = "";
        String msgNgTo = "";
        String msgHoanHao = "";
        String error = "";
        int number;
        try {
            number = Integer.parseInt(numberStr);
            
            if(kiemTraSoChan(number)) {
                msgChan = "Là số chẵn";
            } else {
                msgChan = "Không là số chẵn";
            }
            if(kiemTraSoLe(number)) {
                msgLe = "Là số lẻ";
            } else {
                msgLe = "Không là số lẻ";
            }
            if(kiemtraSoHoanHao(number)){
                msgHoanHao = "Là số hoàn hảo";
            } else {
                msgHoanHao = "Không là số hoàn hảo";
            }
            
            if(kiemTraSoNguyenTo(number)){
                msgNgTo = "Là số nguyên tố";
            } else {
                msgNgTo = "Không là số nguyên tố";
            }
            
            request.setAttribute("msgLe", msgLe);
            request.setAttribute("msgChan", msgChan);
            request.setAttribute("msgHoanHao", msgHoanHao);
            request.setAttribute("msgNgTo", msgNgTo);
            request.setAttribute("number", number);
            request.getRequestDispatcher("view.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            error = "Invalid input! Try Again";
            request.setAttribute("error", error);
            request.getRequestDispatcher("view.jsp").forward(request, response);
        }
    }
    
    public static boolean kiemTraSoChan(int number) {
        return number % 2 == 0;
    }
    
    public static boolean kiemTraSoLe(int number) {
        return number % 2 != 0;
    }
    
    public static boolean kiemtraSoHoanHao(int a) {
        int sum = 0;
        for (int i = 1; i <= a / 2; i++) {
            if (a % i == 0) // tổng các ước số của a
            {
                sum += i;
            }
        }
        if (sum == a) {
            return true;
        }
        return false;
    }
    
    public static boolean kiemTraSoNguyenTo(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Number is divisible by another number, so not prime
            }
        }
        return true; // Number is prime
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
