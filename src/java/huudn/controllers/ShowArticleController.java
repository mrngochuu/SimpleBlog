/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.controllers;

import huudn.daos.ArticleDAO;
import huudn.daos.CommentDAO;
import huudn.daos.StatusDAO;
import huudn.daos.UserDAO;
import huudn.dtos.ArticleDTO;
import huudn.dtos.CommentDTO;
import huudn.dtos.StatusDTO;
import huudn.dtos.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ngochuu
 */
public class ShowArticleController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "detailsArticle.jsp";

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
            int articleID = Integer.parseInt(request.getParameter("articleID"));
            if (articleID > 0) {
                StatusDAO statusDAO = new StatusDAO();
                StatusDTO statusDTO = statusDAO.getObjectByName("active");
                if (statusDTO != null) {
                    ArticleDAO articleDAO = new ArticleDAO();
                    ArticleDTO articleDTO = articleDAO.getDetailsArticle(articleID, statusDTO.getStatusID());
                    if (articleDTO == null) {
                        request.setAttribute("ERROR", "The article does not found!");
                    } else {
                        request.setAttribute("ARTICLE_DETAILS", articleDTO);
                        UserDAO userDAO = new UserDAO();
                        UserDTO userDTO = userDAO.getNameByEmail(articleDTO.getEmail());
                        if (userDTO != null) {
                            request.setAttribute("AUTHOR_DETAILS", userDTO);
                            CommentDAO commentDAO = new CommentDAO();
                            List<CommentDTO> list = commentDAO.getListComment(articleID);
                            request.setAttribute("LIST_COMMENT", list);
                            url = SUCCESS;
                        } else {
                            request.setAttribute("ERROR", "The article's author does not found!");
                        }
                    }
                } else {
                    request.setAttribute("ERROR", "The status cannot find!");
                }
            } else {
                request.setAttribute("ERROR", "The article can not find!");
            }
        } catch (Exception e) {
            log("ERROR at ShowArticleController: " + e.getMessage());
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
