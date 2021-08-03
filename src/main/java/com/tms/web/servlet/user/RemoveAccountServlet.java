package com.tms.web.servlet.user;

import com.tms.entity.User;
import com.tms.service.CalcService;
import com.tms.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "/RemoveAccountServlet", urlPatterns = "/RemoveAccount")
public class RemoveAccountServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final CalcService calcService = new CalcService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        User user = (User) req.getSession().getAttribute("user");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            boolean valid = userService.validPassUname(password, username);
            boolean matchUsername = user.getUsername().equalsIgnoreCase(username);
            boolean matchPassword = user.getPassword().equalsIgnoreCase(password);
            boolean existsCalcHistory = calcService.existsByUsernameCalcHistory(user.getUsername());

            if (matchUsername & matchPassword & valid) {
                userService.deleteByUsername(username);
                    session.invalidate();

                    if(existsCalcHistory) {
                        calcService.deleteFromCalcHistoryByUsername(user.getUsername());
                        session.invalidate();
                    }} else {
                resp.getWriter().print("Password or username is incorrect");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
