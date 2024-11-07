/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.homepage;

import dal.implement.CategoryDAO;
import dal.implement.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.PageControl;
import model.Product;

/**
 *
 * @author stephhoang
 */
public class HomeController extends HttpServlet {
   
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
            out.println("<title>Servlet HomeController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    ProductDAO pDAO = new ProductDAO();
    CategoryDAO cDAO = new CategoryDAO();
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
        PageControl pageControl = new PageControl();
        List<Product> listProduct = findProductDoGet(request, pageControl);
        //get list category
        List<Category> listCategory = cDAO.findAll();

        //set listProduct, listCategory to session
        HttpSession session = request.getSession();
        session.setAttribute("products", listProduct);
        session.setAttribute("categories", listCategory);
        request.setAttribute("pageControl", pageControl);
        request.getRequestDispatcher("view/homepage/home.jsp").forward(request, response);
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
        response.sendRedirect("home");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    private List<Product> findProductDoGet(HttpServletRequest request, PageControl pagecontrol) {
        //get ve page 
        String pageRaw = request.getParameter("page");
        //valid page
        int page;
        try {
            page = Integer.parseInt(pageRaw);
            if (page <= 0) {
                page = 1;
            }
        } catch (NumberFormatException e) {
            page = 1;
        }

        //get ve search
        String action = request.getParameter("action") == null
                ? "default"
                : request.getParameter("action");
        //get list product dao
        List<Product> listProduct;
        //get request URL
        String requestURL = request.getRequestURL().toString();
        int totalRecord = 0;
        switch (action) {
            case "searchByCategory":
                String categoryId = request.getParameter("categoryId");
                totalRecord = pDAO.findTotalRecordByCategory(categoryId);
                listProduct = pDAO.findByCategory(categoryId, page);
                pagecontrol.setUrlPattern(requestURL + "?search=searchByCategory&categoryId=" + categoryId + "&");
                break;
            case "searchByKeyword":
                String keyword = request.getParameter("keyword");
                totalRecord = pDAO.findTotalRecordByName(keyword);
                listProduct = pDAO.findByName(keyword, page);
                pagecontrol.setUrlPattern(requestURL + "?search=searchByKeyword&keyword=" + keyword + "&");
                break;
            default:
                totalRecord = pDAO.findTotalRecord();
                listProduct = pDAO.findByPage(page);
                pagecontrol.setUrlPattern(requestURL + "?");
        }
        //total record
        //total page
        int totalPage = (totalRecord % 12) == 0
                ? (totalRecord / 12)
                : (totalRecord / 12) + 1;
        //set total record, total page, page vao pageControl
        pagecontrol.setPage(page);
        pagecontrol.setTotalPage(totalPage);
        pagecontrol.setTotalRecord(totalRecord);
        return listProduct;
    }

}
