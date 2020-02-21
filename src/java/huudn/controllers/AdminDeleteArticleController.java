/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.controllers;

import huudn.daos.ArticleDAO;
import huudn.daos.StatusDAO;
import huudn.dtos.StatusDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ngochuu
 */
public class AdminDeleteArticleController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "AdminSearchArticleController";
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
        String url = ERROR;
        try {
            String articleStr = request.getParameter("articleID");
            try {
                int articleID = Integer.parseInt(articleStr);
                StatusDTO statusDTO = new StatusDAO().getObjectByName("deleted");
                if(statusDTO != null) {
                    if(new ArticleDAO().updateStatusArticle(articleID, statusDTO.getStatusID())) {
                        request.setAttribute("MESSAGE", "Updating status is successful!");
                    } else {
                        request.setAttribute("MESSAGE", "Updating status is failed!");
                    }
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "The status cannot find!");
                }
            } catch (Exception e) {
                request.setAttribute("ERROR", "The article does not exist!");
            }
        } catch (Exception e) {
            log("ERROR at AdminApprovalArticleController: " + e.getMessage());
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

}
