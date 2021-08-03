package com.tms.web.servlet.user;

import com.tms.entity.User;
import com.tms.service.CalcService;
import com.tms.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final CalcService calcService = new CalcService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            User user = (User) req.getSession().getAttribute("user");
            int id = Integer.parseInt(req.getParameter("id"));
            boolean existById = userService.existById(id);
            boolean existsCalcHistory = calcService.existsByUsernameCalcHistory(user.getUsername());

            if (existById) {
                userService.deleteById(id);
                session.invalidate();

                if(existsCalcHistory){
                    calcService.deleteFromCalcHistoryByUsername(user.getUsername());
                    session.invalidate();
                }} else {
                resp.getWriter().print("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}