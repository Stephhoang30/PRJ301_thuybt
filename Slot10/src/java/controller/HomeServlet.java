/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CurrencyDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Currency;

/**
 *
 * @author stephhoang
 */
public class HomeServlet extends HttpServlet {

    CurrencyDAO cDAO = new CurrencyDAO();

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
            out.println("<title>Servlet HomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            forwardToUpdatePage(request, response);
        } else {
            List<Currency> listCur = cDAO.getAll();
            request.setAttribute("listCur", listCur);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
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
        String action = request.getParameter("action") == null
                ? "" : request.getParameter("action");
        List<Currency> listCur = new ArrayList<>();

        switch (action) {
            case "search":
                listCur = search(request, response);
                break;
            case "saveUpdate":
                saveUpdatedCurrency(request, response);
                break;
            default:
                throw new AssertionError();
        }

        request.getSession().setAttribute("listCur", listCur);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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

    private List<Currency> search(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String name = request.getParameter("name");

        List<Currency> listCur = cDAO.getByCodeAndName(code, name);
        request.setAttribute("code", code);
        request.setAttribute("name", name);

        return listCur;

    }

    private void forwardToUpdatePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        Currency currency = cDAO.getByCode(code);
        if (currency != null) {
            request.setAttribute("currency", currency);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Currency not found");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }

    private void saveUpdatedCurrency(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String rateStr = request.getParameter("rate");

        try {
            float rate = Float.parseFloat(rateStr);

            // Create updated currency object
            Currency currency = new Currency(code, name, description, rate);

            // Update currency in database
            cDAO.updateCurrency(currency);

            // Set success message and redirect back to home
            request.setAttribute("message", "Currency updated successfully.");
            request.getRequestDispatcher("home.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid rate format.");
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
    }

}
