/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.controllers;

import huudn.daos.ArticleDAO;
import huudn.daos.StatusDAO;
import huudn.daos.UserDAO;
import huudn.dtos.ArticleDTO;
import huudn.dtos.StatusDTO;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ngochuu
 */
public class AdminSearchArticleController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "admin.jsp";

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
            //set stautus for choosing
            HttpSession session = request.getSession();
            int pageNum;
            int statusID;

            List<StatusDTO> listStatuses = (List<StatusDTO>) session.getAttribute("LIST_STATUS");
            if (listStatuses == null) {
                StatusDAO statusDAO = new StatusDAO();
                listStatuses = statusDAO.getAllStatus();
                session.setAttribute("LIST_STATUS", listStatuses);
            }

            String txtSearch = request.getParameter("txtSearch");
            String txtAuthorName = request.getParameter("txtAuthorName");
            String statusStr = request.getParameter("cbStatus");
            String pageStr = request.getParameter("txtPage");

            if (txtSearch == null) {
                txtSearch = "";
            } else {
                txtSearch = txtSearch.trim();
            }

            if (txtAuthorName == null) {
                txtAuthorName = "";
            } else {
                txtAuthorName = txtAuthorName.trim();
            }

            if (statusStr == null || statusStr.isEmpty()) {
                statusStr = "0";
            }

            try {
                statusID = Integer.parseInt(statusStr);
                UserDAO userDAO = new UserDAO();
                Hashtable<String, String> listUsers = userDAO.searchByName(txtAuthorName);
                if (listUsers == null) {
                    request.setAttribute("TOTAL_PAGE", 1);
                } else {
                    request.setAttribute("LIST_USERS", listUsers);
                    ArticleDAO articleDAO = new ArticleDAO();
                    //count rows and setting emailStr by emails that are separated by &
                    int totalRow = 0;
                    String emailStr = "";

                    for (String email : listUsers.keySet()) {
                        int totalRowEachAuthor = articleDAO.getTotalRow(txtSearch, email, statusID);
                        if (totalRowEachAuthor > 0) {
                            totalRow += totalRowEachAuthor;
                            emailStr += email + "&";
                        }
                    }
                    if (totalRow > 0) {
                        //set total pages

                        int totalPage = totalRow / 20;
                        if (totalRow % 20 > 0) {
                            totalPage++;
                        }
                        request.setAttribute("TOTAL_PAGE", totalPage);
                        try {
                            pageNum = Integer.parseInt(pageStr);
                            if (pageNum <= 0 || pageNum > totalPage) {
                                pageNum = 1;
                            }
                        } catch (Exception e) {
                            pageNum = 1;
                        }
                        //set list articles
                        List<ArticleDTO> listArticles = articleDAO.searchArticleForAdmin(txtSearch, emailStr, statusID, pageNum, 20);
                        request.setAttribute("LIST_ARTICLES", listArticles);
                    } else {
                        request.setAttribute("TOTAL_PAGE", 1);
                    }
                }
                url = SUCCESS;
            } catch (Exception e) {
                request.setAttribute("ERROR", "The status does not exist!");
            }
        } catch (Exception e) {
            log("ERROR at AdminSearchArticleController: " + e.getMessage());
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
