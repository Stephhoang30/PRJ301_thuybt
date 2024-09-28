/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Product;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author stephhoang
 */
public class SearchAndSortServlet extends HttpServlet {

    ProductDAO pDAO = new ProductDAO();

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
            out.println("<title>Servlet SearchServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
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

        String keyword = request.getParameter("keyword");
        String choice = request.getParameter("choice");
        String sortField = request.getParameter("sortField");
        String sortOrder = request.getParameter("sortOrder");

        List<Product> listProduct = new ArrayList<>();

        if (keyword == null || keyword.trim().isEmpty()) {
            listProduct = pDAO.getAll();
            
        } else if (choice != null) {
            switch (choice) {
                case "search-by-id":
                    listProduct = pDAO.findByID(keyword);
                    break;
                case "search-by-name":
                    listProduct = pDAO.findByName(keyword);
                    break;
                case "search-by-quantity":
                    listProduct = pDAO.findByQuantity(keyword);
                    break;
                case "search-by-price":
                    listProduct = pDAO.findByPrice(keyword);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        if (sortField != null && sortOrder != null && !listProduct.isEmpty()) {
            switch (sortField) {
                case "id":
                    listProduct = pDAO.sortProductsByField(listProduct, "id", sortOrder);
                    break;
                case "name":
                    listProduct = pDAO.sortProductsByField(listProduct, "name", sortOrder);
                    break;
                case "quantity":
                    listProduct = pDAO.sortProductsByField(listProduct, "quantity", sortOrder);
                    break;
                case "price":
                    listProduct = pDAO.sortProductsByField(listProduct, "price", sortOrder);
                    break;
            }
        }

        request.setAttribute("keyword", keyword);
        request.setAttribute("choice", choice);
        request.setAttribute("sortField", sortField);
        request.setAttribute("sortOrder", sortOrder);
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("listProduct.jsp").forward(request, response);

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
