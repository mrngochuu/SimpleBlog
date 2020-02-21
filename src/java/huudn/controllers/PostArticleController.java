/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.controllers;

import huudn.daos.ArticleDAO;
import huudn.daos.StatusDAO;
import huudn.dtos.ArticleDTO;
import huudn.dtos.ArticleErrorObject;
import huudn.dtos.StatusDTO;
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
public class PostArticleController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "postArticle.jsp";
    private static final String SUCCESS = "SearchArticleController";

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
            StatusDAO statusDAO = new StatusDAO();
            StatusDTO statusDTO = statusDAO.getObjectByName("new");
            if (statusDTO != null) {
                String title = request.getParameter("txtTitle");
                String description = request.getParameter("txtDescription");
                String content = request.getParameter("txtContent");

                ArticleErrorObject errorObject = new ArticleErrorObject();
                boolean validate = true;
                if (title.isEmpty()) {
                    validate = false;
                    errorObject.setTitleError("The title's article is required!");
                }

                if (title.length() > 200) {
                    validate = false;
                    errorObject.setTitleError("Maximum length of the title's article is 200 characters!");
                }

                if (description.isEmpty()) {
                    validate = false;
                    errorObject.setDescriptionError("The description's article is required!");
                }

                if (description.length() > 200) {
                    validate = false;
                    errorObject.setDescriptionError("Maximum length of the description's article is 200 characters!");
                }

                if (content.isEmpty()) {
                    validate = false;
                    errorObject.setContentError("The content's article is required!");
                }

                if (validate) {
                    HttpSession session = request.getSession();
                    ArticleDTO articleDTO = new ArticleDTO();
                    ArticleDAO articleDAO = new ArticleDAO();

                    UserDTO userDTO = (UserDTO) session.getAttribute("USER");

                    articleDTO.setTitle(title);
                    articleDTO.setDescription(description);
                    articleDTO.setContent(content);
                    articleDTO.setPostingDate(new Date());
                    articleDTO.setStatusID(statusDTO.getStatusID());
                    articleDTO.setEmail(userDTO.getEmail());

                    if (articleDAO.postArticle(articleDTO)) {
                        url = SUCCESS;
                        request.setAttribute("MESSAGE", "Your article will be moderated by the Admin before being posted!");
                    } else {
                        request.setAttribute("ERROR", "Post new Article failed!");
                    }
                } else {
                    request.setAttribute("INVALID", errorObject);
                    url = INVALID;
                }
            } else {
                request.setAttribute("ERROR", "The status cannot find!");
            }
        } catch (Exception e) {
            log("ERROR at PostArticleController: " + e.getMessage());
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
