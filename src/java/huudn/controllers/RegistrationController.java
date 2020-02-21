/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.controllers;

import huudn.daos.DomainDAO;
import huudn.daos.RoleDAO;
import huudn.daos.StatusDAO;
import huudn.daos.UserDAO;
import huudn.dtos.DomainDTO;
import huudn.dtos.RoleDTO;
import huudn.dtos.StatusDTO;
import huudn.dtos.UserDTO;
import huudn.dtos.UserErrorObject;
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
public class RegistrationController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "registration.jsp";
    private static final String SUCCESS = "SendingCodeController";

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
                String email = request.getParameter("txtEmail").trim();
                String fullname = request.getParameter("txtFullname").trim();
                String password = request.getParameter("txtPassword").trim();
                String confirm = request.getParameter("txtConfirm").trim();

                UserDAO userDAO = new UserDAO();

                boolean validation = true;
                UserErrorObject errorObj = new UserErrorObject();
                if (email.isEmpty()) {
                    validation = false;
                    errorObj.setEmailError("Your email is required!");
                }
                
                int index = email.indexOf("@");
                String emailStr = email.substring(0, index);
                String domainStr = email.substring(index, email.length());

                if (!emailStr.matches("[a-zA-Z0-9]+([!#$%&'*+-/=?^_`{|}~.][a-zA-Z0-9]+)*")) {
                    validation = false;
                    errorObj.setEmailError("Your local-part of email address is invalid!");
                }
                
                DomainDAO domainDAO = new DomainDAO();
                if(!domainDAO.checkDomain(domainStr)) {
                    validation = false;
                    errorObj.setDomainError("Your domain name of email address is invalid!");
                    List<DomainDTO> listDomains = domainDAO.getDomail();
                    request.setAttribute("LIST_DOMAINS", listDomains);
                }
                
                if (email.length() > 50) {
                    validation = false;
                    errorObj.setEmailError("Max length of email is 50 characters!");
                }

                int statusID = userDAO.checkEmailExisted(email);
                if (statusID != 0 && statusID != statusDTO.getStatusID()) {
                    validation = false;
                    errorObj.setDuplicationError("Email already exists!");
                }

                if (fullname.isEmpty()) {
                    validation = false;
                    errorObj.setFullnameError("Your name is required!");
                }

                if (fullname.length() > 50) {
                    validation = false;
                    errorObj.setFullnameError("Max length of fullname is 50 characters!");
                }

                if (password.isEmpty()) {
                    validation = false;
                    errorObj.setPasswordError("Your password is required!");
                }

                if (password.length() < 6 || password.length() > 20) {
                    validation = false;
                    errorObj.setPasswordError("Length of password is from 6 to 20 characters!");
                }

                if (!confirm.equals(password) && (password.length() >= 6 && password.length() <= 20)) {
                    validation = false;
                    errorObj.setConfirmError("Confirm password does not match!");
                }

                if (validation) {
                    UserDTO userDTO = new UserDTO();
                    RoleDAO roleDAO = new RoleDAO();
                    RoleDTO roleDTO = roleDAO.getObjectByName("member");

                    userDTO.setEmail(email);
                    userDTO.setName(fullname);
                    userDTO.setPassword(password);
                    userDTO.setStatusID(statusDTO.getStatusID());
                    userDTO.setRoleID(roleDTO.getRoleID());

                    if (statusID == 0) {
                        if (userDAO.registerAccount(userDTO)) {
                            url = SUCCESS;
                        } else {
                            request.setAttribute("ERROR", "Register new Account failed!");
                        }
                    } else if (statusID == statusDTO.getStatusID()) {
                        if (userDAO.updateAccount(userDTO)) {
                            url = SUCCESS;
                        } else {
                            request.setAttribute("ERROR", "Register new Account failed!");
                        }
                    }
                } else {
                    url = INVALID;
                    request.setAttribute("INVALID", errorObj);
                }
            } else {
                request.setAttribute("ERROR", "The status cannot find!");
            }
        } catch (Exception e) {
            log("ERROR at RegistrationController: " + e.getMessage());
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
