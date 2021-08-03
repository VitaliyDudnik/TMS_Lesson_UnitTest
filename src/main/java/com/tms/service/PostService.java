package com.tms.service;

import com.tms.entity.Post;
import com.tms.DAO.post.PostDAO;

import java.util.List;

public class PostService {
    private final PostDAO postDAO = new PostDAO();

    public boolean add(Post post) {
        postDAO.save(post);
        return true;
    }

    public void updatePost(int id, String description) {
        postDAO.updatePost(id, description);
    }

    public List<Post> getAll() {
        return postDAO.findAll();
    }

    public void delete(int id) {
        postDAO.delete(id);
    }

    public boolean postDataPattern(String title, String description) {
        return postDAO.postDataPattern(title, description);
    }

    public boolean postDescriptionPattern(String description) {
        return postDAO.postDescriptionPattern(description);
    }

    public void approvePost(int id){
        postDAO.approved(id);
    }

}
