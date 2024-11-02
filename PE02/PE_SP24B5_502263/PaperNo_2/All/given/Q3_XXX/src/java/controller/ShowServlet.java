/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BoatDAO;
import dal.DepartPlaceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Boats;
import model.DepartPlaces;

/**
 *
 * @author stephhoang
 */
public class ShowServlet extends HttpServlet {

    BoatDAO bDAO = new BoatDAO();
    DepartPlaceDAO deDAO = new DepartPlaceDAO();

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
        
        HttpSession session = request.getSession();

        List<Boats> listBoats = bDAO.getBoats(null);
        List<DepartPlaces> listDe = deDAO.getDepartPlaces();

        String depIDStr = request.getParameter("depID");
        if (depIDStr != null) {
            listBoats = bDAO.getBoats(Integer.parseInt(depIDStr));
            session.setAttribute("chosenDep", depIDStr);
        }
        session.setAttribute("listBoats", listBoats);
        session.setAttribute("listDe", listDe);
  
        request.getRequestDispatcher("show.jsp").forward(request, response);
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
