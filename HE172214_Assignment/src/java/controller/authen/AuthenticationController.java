/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.authen;

import dal.implement.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author stephhoang
 */
public class AuthenticationController extends HttpServlet {

    AccountDAO aDAO = new AccountDAO();

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
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";
        String url = "";
        switch (action) {
            case "login":
                url = "view/authen/login.jsp";
                break;
            case "logout":
                url = logout(request, response);
                break;
            case "signup":
                url = "view/authen/signup.jsp";
                break;
            default:
                url = "home";
        }

        request.getRequestDispatcher(url).forward(request, response);
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
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";
        String url = "";
        switch (action) {
            case "login":
                url = loginDoPost(request, response);
                break;
            case "signup":
                url = signup(request, response);
                break;
            default:
                url = "home";
        }

        request.getRequestDispatcher(url).forward(request, response);
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

    private String loginDoPost(HttpServletRequest request, HttpServletResponse response) {
        String url = "";
        // get info
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        // check existed
        Account foundAccount = aDAO.checkUsernameAndPassword(account);

        // true => homes
        if (foundAccount != null) {
            HttpSession session = request.getSession();
            session.setAttribute("account", foundAccount);
            url = "home";

            // false => login.jsp + error
        } else {
            url = "view/authen/login.jsp";
            request.setAttribute("error", "Invalid username or password!");
        }

        return url;

    }

    private String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "home";
    }

    private String signup(HttpServletRequest request, HttpServletResponse response) {
        String url = "";
        // get info
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        if (username == null || username.trim().isEmpty()) {
            url = "view/authen/signup.jsp";
            request.setAttribute("error", "Username is required!");
        } else if (password == null || password.trim().isEmpty()) {
            url = "view/authen/signup.jsp";
            request.setAttribute("error", "Password is required!");
        } else if (!password.equals(confirmPassword)) {
            url = "view/authen/signup.jsp";
            request.setAttribute("error", "Passwords do not match!");
        } else {
            Account a = new Account();
            a.setUsername(username);
            a.setPassword(password);

            // Check if the username already exists
            boolean checkUsername = aDAO.checkUsername(a);

            if (checkUsername) {
                // Username already exists
                url = "view/authen/signup.jsp";
                request.setAttribute("error", "Username already exists!");
            } else {
                // Register the new account
                aDAO.insert(a);
                url = "home";
                request.setAttribute("message", "Signup successful! Please log in.");
            }
        }

        return url;
    }

}
