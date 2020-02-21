/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.controllers;

import huudn.daos.CodeDAO;
import huudn.daos.StatusDAO;
import huudn.daos.UserDAO;
import huudn.dtos.CodeDTO;
import huudn.dtos.StatusDTO;
import huudn.dtos.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ngochuu
 */
public class ConfirmationController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "confirmation.jsp";
    private static final String SUCCESS = "login.jsp";

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

                String email = request.getParameter("txtEmail").trim();
                String codeStr = request.getParameter("txtCode").trim();
                boolean validation = true;
                int codeNum = 0;
                try {
                    codeNum = Integer.parseInt(codeStr);
                } catch (Exception e) {
                    validation = false;
                }
                if (validation) {
                    CodeDTO codeDTO = new CodeDTO();
                    CodeDAO codeDAO = new CodeDAO();

                    codeDTO.setEmail(email);
                    codeDTO.setCodeNum(codeNum);

                    //check and delete record from tblCodes with condition is the same email and code
                    if (codeDAO.deleteCode(codeDTO)) {
                        UserDTO userDTO = new UserDTO();
                        userDTO.setEmail(email);
                        userDTO.setStatusID(statusDTO.getStatusID());
                        UserDAO userDAO = new UserDAO();
                        if (userDAO.updateStatusAccount(userDTO)) {
                            request.setAttribute("MESSAGE", "Register new Account successful!");
                            url = SUCCESS;
                        } else {
                            request.setAttribute("ERROR", "Update account failed!");
                        }
                    } else {
                        request.setAttribute("INVALID", "Code does not match!");
                        url = INVALID;
                    }
                } else {
                    request.setAttribute("INVALID", "Code is a 4-digit number!");
                    url = INVALID;
                }
            } else {
                request.setAttribute("ERROR", "The status cannot find!");
            }
        } catch (Exception e) {
            log("ERROR at ConfirmationController: " + e.getMessage());
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
