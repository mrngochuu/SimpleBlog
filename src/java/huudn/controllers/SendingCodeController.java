/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huudn.controllers;

import huudn.daos.CodeDAO;
import huudn.dtos.CodeDTO;
import huudn.utils.MailUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ngochuu
 */
public class SendingCodeController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "confirmation.jsp";

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
            String email = request.getParameter("txtEmail");
            String fullname = request.getParameter("txtFullname");
            CodeDTO codeDTO = new CodeDTO();
            codeDTO.setEmail(email);
            codeDTO.setCodeNum((int) Math.floor((Math.random() * 8999)) + 1000);
            CodeDAO codeDAO = new CodeDAO();
            if (codeDAO.checkExisted(email)) {
                if (codeDAO.updateCode(codeDTO)) {
                    MailUtils mailUtils = new MailUtils(email, fullname, codeDTO.getCodeNum());
                    mailUtils.sendMail();
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Sending code failed");
                }
            } else {
                if (codeDAO.storeCode(codeDTO)) {
                    MailUtils mailUtils = new MailUtils(email, fullname, codeDTO.getCodeNum());
                    mailUtils.sendMail();
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Sending code failed");
                }
            }
        } catch (Exception e) {
            log("ERROR at SendingCodeController: " + e.getMessage());
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
