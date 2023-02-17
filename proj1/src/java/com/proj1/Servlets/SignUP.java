
package com.proj1.Servlets;

import com.proj1.Databases.user_database;
import com.proj1.Entities.user_info;
import com.proj1.Helpers.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig
public class SignUP extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          
            
            //fetching all data of user .....
            
           String terms = request.getParameter("terms");
           
           if(terms == null)
           {
           
           out.println("please accept the terms and condition..");
           }            
           else{
           String name = request.getParameter("user_name");
           String email = request.getParameter("user_email");
           String password = request.getParameter("user_password");
           String gender = request.getParameter("gender");
           String about = request.getParameter("about");
           
           //storing data of user in class
           
           user_info user_info = new user_info(name,email,password,gender,about);
           
           //storing data of user in database
           
           user_database user = new user_database(ConnectionProvider.getConnection());
          if(user.save_user_info(user_info)){
          out.println("user info is stored");
          }
          else{
          out.println("error.....");
          }
                    
           }
            
            
            
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
