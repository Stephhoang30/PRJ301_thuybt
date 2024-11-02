/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Model.StringQ2;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Tra Pham
 */
@WebServlet(urlPatterns = {"/load"})
public class load extends HttpServlet {

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
            out.println("<title>Servlet load</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet load at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        String str = request.getParameter("str");
        String n = request.getParameter("n");
        int num = 0;
        HttpSession session = request.getSession();
        ArrayList<StringQ2> list = (ArrayList<StringQ2>) session.getAttribute("listS");

        if (list == null) {
            list = new ArrayList<>();
        }

        try {
            num = Integer.parseInt(n);
        } catch (Exception e) {

        }

        if (!(0 < num && num < str.length())) {
            request.setAttribute("mess", "You must input an integer n: 0 &lt; n &lt;length of string str");
        } else {
            String result = str.substring(0, num+1);
            request.setAttribute("result", result);
            request.setAttribute("str", str);
            request.setAttribute("n", n);
            boolean valid = true;
            for (StringQ2 q : list) {
                if (q.getStr().equalsIgnoreCase(str) && q.getIndex().equalsIgnoreCase(n)) {
                    request.setAttribute("exist", "Execution existed !");
                    valid = false;
                    break;
                }
            }
            if (valid) {
                list.add(new StringQ2(str, n, result));
            }
            session.setAttribute("listS", list);

        }
        request.getRequestDispatcher("MyExecution.jsp").forward(request, response);

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
        processRequest(request, response);
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
