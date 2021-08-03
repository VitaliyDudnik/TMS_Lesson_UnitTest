package com.tms.service;

import com.tms.DataPattern.CommentPattern;
import com.tms.entity.Comment;
import com.tms.entity.Post;
import com.tms.DAO.comment.CommentDAO;

import java.util.List;

public class CommentService {
    private final CommentDAO commentDAO = new CommentDAO();
    private final CommentPattern commentPattern = new CommentPattern();


    public boolean add(Comment comment) {
        commentDAO.save(comment);
        return true;
    }

    public List<Comment> getAll(int postId) {
        return commentDAO.getCommentList(new Post(postId, null, null, null, null, true));
    }

    public List<Comment> getComments() {
        return commentDAO.getComments();
    }

    public Comment getCommentById(int id){
       return commentDAO.getCommentById(id);

    }

    public void updateComment(int id, String text) {
        commentDAO.updateComment(id, text);
    }

    public void deleteByCommentId(int id) {
        commentDAO.deleteByCommentId(id);
    }

    public  void deleteCommentByPostId(int postId){
        commentDAO.deleteByPostId(postId);
    }

    public void approveComment(int id) {
        commentDAO.approved(id);
    }

    public boolean commentPattern(String text){
        return commentPattern.commentPattern(text);
    }

}
