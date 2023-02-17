/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.proj1.Servlets;

import com.proj1.Helpers.Helpers;
import com.proj1.Databases.user_database;
import com.proj1.Entities.Message;
import com.proj1.Entities.user_info;
import com.proj1.Helpers.ConnectionProvider;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;

@MultipartConfig
public class Update_profile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update_profile</title>");
            out.println("</head>");
            out.println("<body>");

            String userEmail = request.getParameter("user_email");
            String userName = request.getParameter("user_name");
            String userPassword = request.getParameter("user_password");
            String userAbout = request.getParameter("user_about");
            Part part = request.getPart("image");
            String imageName = part.getSubmittedFileName();

            HttpSession session = request.getSession();

            user_info user = (user_info) session.getAttribute("CurrentUser");

            user.setEmail(userEmail);
            user.setName(userName);
            user.setPassword(userPassword);
            user.setAbout(userAbout);
            user.setProfile(imageName);
            String oldFile = user.getProfile();
            

            user_database update = new user_database(ConnectionProvider.getConnection());

            if (update.update_User_Info(user)) {

                out.println("succesfully changed");

                ServletContext context = request.getServletContext();
                String path = "D:\\java_programs\\proj1\\build\\web\\images\\" + user.getProfile();
                String oldPath = "D:\\java_programs\\proj1\\build\\web\\images\\" +oldFile;

                Helpers.removeImage(oldPath);

                if (Helpers.saveImage(part.getInputStream(), path)) {

                    Message msg = new Message("profile picture updated", "success", "alert-success");

                    session.setAttribute("msg", msg);

                } else {
                    Message msg = new Message("An error occured..", "error", "alert-danger");
                    session.setAttribute("msg", msg);

                }

            } else {
                Message msg = new Message("An error occured..", "error", "alert-danger");
                session.setAttribute("msg", msg);

            }
            response.sendRedirect("profile.jsp");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
