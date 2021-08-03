package com.tms.web.servlet.user;

import com.tms.entity.User;
import com.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {
    private final UserService u = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);
    }

    @Override()
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            User byUsername = u.getByUsername(username);
            boolean valid = u.validPassUname(password, username);
           if(byUsername!=null) {
               boolean equalPassword = byUsername.getPassword().equalsIgnoreCase(password);

            if (equalPassword & valid) {

                req.getSession().setAttribute("user", byUsername);
                req.setAttribute("welcome", "Welcome: " + username);
                req.getServletContext().getRequestDispatcher("/RegUserContent.jsp").forward(req, resp);

            }} else {
                req.setAttribute("incorrectUsernamePassword", "Incorrect username or password" + username+","+password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

