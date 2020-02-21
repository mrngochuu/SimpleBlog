/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.controllers;

import huudn.daos.RoleDAO;
import huudn.daos.StatusDAO;
import huudn.daos.UserDAO;
import huudn.dtos.RoleDTO;
import huudn.dtos.StatusDTO;
import huudn.dtos.UserDTO;
import huudn.dtos.UserErrorObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ngochuu
 */
public class LoginController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "login.jsp";
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
            String email = request.getParameter("txtEmail").trim();
            String password = request.getParameter("txtPassword").trim();

            boolean validation = true;
            UserErrorObject errorObj = new UserErrorObject();

            if (email.isEmpty()) {
                validation = false;
                errorObj.setEmailError("Email is required!");
            }

            if (password.isEmpty()) {
                validation = false;
                errorObj.setPasswordError("Password is required!");
            }

            if (validation) {
                StatusDAO statusDAO = new StatusDAO();
                StatusDTO statusDTO = statusDAO.getObjectByName("active");
                if (statusDTO != null) {
                    UserDAO userDAO = new UserDAO();
                    UserDTO userDTO = userDAO.checkLogin(email, password, statusDTO.getStatusID());
                    if (userDTO != null) {
                        RoleDAO roleDAO = new RoleDAO();
                        RoleDTO roleDTO = roleDAO.getObjectByID(userDTO.getRoleID());
                        HttpSession session = request.getSession();

                        session.setAttribute("USER", userDTO);
                        session.setAttribute("ROLE", roleDTO);
                        url = SUCCESS;
                    } else {
                        errorObj.setLoginError("Account is not found!");
                        request.setAttribute("INVALID", errorObj);
                        url = INVALID;
                    }
                } else {
                    request.setAttribute("ERROR", "Login failed!");
                }
            } else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at LoginController: " + e.getMessage());
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
