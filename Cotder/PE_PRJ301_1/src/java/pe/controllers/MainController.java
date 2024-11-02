/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.entity.tblUsers;
import pe.utils.tblUsersDAO;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";
    private static final String FASHION_PAGE = "fashionList.jsp";

    tblUsersDAO dao = new tblUsersDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOGIN_PAGE;
            }
//            your code here
            HttpSession session = request.getSession();
            switch (action) {
                case "login":
                    url = login(request, response, session);
                    break;
                case "logout":
                    logOut(session);
                    url = LOGIN_PAGE;
                default:
                    throw new AssertionError();
            }

        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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

    private String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        // get ve username, password
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");

        // kiem tra xem username, password co ton tai trong database khong
        tblUsers user = dao.checkUandP(userID, password);

        // neu co ton tai trong DB => fashionList.jsp
        if (user != null) {
            session.setAttribute("user", user);
            return FASHION_PAGE;
            
        } // nguoc lai thi se set loi "Incorrect UserID or Password" va tra ve trang chuyen den la login.jsp
        else {
            request.setAttribute("error", "Incorrect UserID or Password");
            return LOGIN_PAGE;
        }
    }

    private void logOut(HttpSession session) {
        session.removeAttribute("user");
    }
}
