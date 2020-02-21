/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.controllers;

import huudn.daos.CommentDAO;
import huudn.dtos.CommentDTO;
import huudn.dtos.UserDTO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ngochuu
 */
public class CommentController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "ShowArticleController";
    private static final String SUCCESS = "ShowArticleController";

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
            String comment = request.getParameter("txtComment").trim();
            
            if(comment.isEmpty()) {
                url = INVALID;
                request.setAttribute("INVALID", "Comment is required!");
            } else {
                int articleID = Integer.parseInt(request.getParameter("articleID"));
                HttpSession session = request.getSession();
                UserDTO userDTO = (UserDTO) session.getAttribute("USER");
                CommentDAO commentDAO = new CommentDAO();
                CommentDTO commentDTO = new CommentDTO();

                commentDTO.setContent(comment);
                commentDTO.setCommentDate(new Date());
                commentDTO.setArticleID(articleID);
                commentDTO.setEmail(userDTO.getEmail());
                
                if(commentDAO.commentArticle(commentDTO)) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Comment failed!");
                }
            }
        } catch (Exception e) {
            log("ERROR at CommentController: " + e.getMessage());
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
