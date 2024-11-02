/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExecuteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExecuteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            try {
                //get n
                int n = Integer.parseInt(request.getParameter("n"));
                //check 5 <= n <= 10
                //true=> calculate
                if (5 <= n && n <= 10) {
                    int sum = tinhTongTu0(n);
                    out.println("<h1>" + sum + "</h1>");
                } else {
                    //false => show error
                    out.println("<h1>" + "You must input ...." + "</h1>");

                }

            } catch (Exception e) {
                out.println("<h1>" + "You must input ...." + "</h1>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    public static int tinhTongTu0(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExecuteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExecuteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
