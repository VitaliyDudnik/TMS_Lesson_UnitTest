package com.tms.web.servlet.user;

import com.tms.entity.Role;
import com.tms.entity.User;
import com.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/RegistrationServlet", urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
    private final UserService u = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(0, name, username, password, Role.USER);

        //checking username and password with pattern
        boolean validUserData = u.validUserData(name, username, password);

        try {
            if (u.findByUsername(username)) {
                req.setAttribute("invalidUsername", "This username is already exist." + username);
                return;
            }

            boolean add = u.add(user);
            if ( add & validUserData) {

                req.getSession().setAttribute("user", u.getByUsername(username));
                req.setAttribute("welcome", "Welcome: " + user.getUsername());
                getServletContext().getRequestDispatcher("/RegUserContent.jsp").forward(req, resp);

            } else {
                req.setAttribute("invalidInputData", "Input data is incorrect");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

