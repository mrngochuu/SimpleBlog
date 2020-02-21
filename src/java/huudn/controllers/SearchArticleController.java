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

/**
 *
 * @author ngochuu
 */
public class SearchArticleController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "index.jsp";

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
            StatusDTO statusDTO = statusDAO.getObjectByName("active");
            if (statusDTO != null) {
                String txtSearch = request.getParameter("txtSearch");
                String pageStr = request.getParameter("txtPage");

                if (txtSearch == null) {
                    txtSearch = "";
                }

                ArticleDAO articleDAO = new ArticleDAO();
                int totalRow = articleDAO.getTotalRow(txtSearch, "", statusDTO.getStatusID());
                if (totalRow > 0) {
                    int totalPage = totalRow / 20;
                    if (totalRow % 20 > 0) {
                        totalPage += 1;
                    }
                    request.setAttribute("TOTAL_PAGE", totalPage);

                    int pageNum;
                    try {
                        pageNum = Integer.parseInt(pageStr);
                        if (pageNum <= 0 || pageNum > totalPage) {
                            pageNum = 1;
                        }
                    } catch (Exception e) {
                        pageNum = 1;
                    }
                    List<ArticleDTO> list = articleDAO.searchArticleByContent(txtSearch, statusDTO.getStatusID(), pageNum, 20);
                    Hashtable<String, String> listUsers = new Hashtable<>();
                    for (ArticleDTO articleDTO : list) {
                        if (!listUsers.contains(articleDTO.getEmail())) {
                            listUsers.put(articleDTO.getEmail(), (new UserDAO().getNameByEmail(articleDTO.getEmail())).getName());
                        }
                    }
                    request.setAttribute("LIST_USERS", listUsers);
                    request.setAttribute("LIST_ARTICLES", list);

                } else {
                    request.setAttribute("TOTAL_PAGE", 1);
                }
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", "The status cannot find!");
            }
        } catch (Exception e) {
            log("ERROR at SearchArticleController: " + e.getMessage());
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
