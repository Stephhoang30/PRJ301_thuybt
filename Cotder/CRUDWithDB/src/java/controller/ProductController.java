/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author stephhoang
 */
public class ProductController extends HttpServlet {

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
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
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

        ProductDAO dao = new ProductDAO();
        
        HttpSession session = request.getSession();

        List<Product> listProduct = (List<Product>) session.getAttribute("listProduct");
        // kiem tra xem co list product o trong Session hay khong
        // TH1: khong he co list product trong Session
        if (listProduct == null) {
            // get du lieu san pham len
            listProduct = dao.findAll();
        }

        // set du lieu vao trong request
        session.setAttribute("listProduct", listProduct);

        // chuyen sang trang list.jsp
        request.getRequestDispatcher("list.jsp").forward(request, response);

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
        List<Product> listProduct;

        switch (action) {
            case "search":
                listProduct = searchProduct(request, response);
                break;
            case "insert":
                listProduct = insertProduct(request, response);
                break;
            case "update":
                listProduct = updateProduct(request, response);
                break;
            case "delete":
                listProduct= deleteProduct(request, response);
                break;
            default:
                throw new AssertionError();
        }

//        HttpSession session = request.getSession();
//        
//        session.setAttribute("listProduct", listProduct);
        request.getSession().setAttribute("listProduct", listProduct);
        response.sendRedirect("product");
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

    private List<Product> searchProduct(HttpServletRequest request, HttpServletResponse response) {

        ProductDAO dao = new ProductDAO();

        // get ve keyword nguoi dung nhap
        String keyword = request.getParameter("keyword");
        // dua vao keyword do, tim trong DB co product nao ma nguoi dung nhap khong

        List<Product> listProduct = dao.findByName(keyword);
        // kiem tra xem List<Product> => list rong => khong tim thay

        // list khong rong => tim thay => set vao request
        return listProduct;

    }

    private List<Product> insertProduct(HttpServletRequest request, HttpServletResponse response) {
        
        ProductDAO dao = new ProductDAO();

        // get vao data
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        Product product = new Product();
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        // insert vao trong DB
        dao.insert(product);

        // get ve toan bo data moi 
        return dao.findAll();

        // tra ve list sau khi insert
    }

    private List<Product> updateProduct(HttpServletRequest request, HttpServletResponse response) {

        ProductDAO dao = new ProductDAO();
        // get vao data

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);

        // update vao DB
        dao.update(product);

        // get ve toan bo data moi
        return dao.findAll();

    }

    private List<Product> deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        
        ProductDAO dao = new ProductDAO();
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        
        Product product = new Product();
        product.setId(id);
        
        dao.deleteById(product);
        
        return dao.findAll();
    }

}
