package com.tms.web.servlet.calcServlet;

import com.tms.entity.CalcOperation;
import com.tms.entity.User;
import com.tms.service.CalcService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "/CalcHistoryServlet", urlPatterns = "/history")
public class CalcHistoryServlet extends HttpServlet {
    private final CalcService calcService = new CalcService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            User user = (User) req.getSession().getAttribute("user");

            List<CalcOperation> all = calcService.findAll();
            List<CalcOperation> historyList;
            historyList = all.stream().filter((a -> a.getUsername().equals(user.getUsername()))).collect(Collectors.toList());

            req.setAttribute("history", historyList);

            req.getServletContext().getRequestDispatcher("/calcHistory.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

