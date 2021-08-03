package com.tms.web.servlet.comment;

import com.tms.service.CommentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteCommentServlet", urlPatterns = "/deleteComment")
public class DeleteCommentServlet extends HttpServlet {
    private final CommentService commentService = new CommentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int commentId = Integer.parseInt(req.getParameter("id"));
            commentService.deleteByCommentId(commentId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
