package com.tms.DAO.post;

import com.tms.DataPattern.PostPattern;
import com.tms.entity.Comment;
import com.tms.entity.Post;
import com.tms.entity.User;
import com.tms.DAO.comment.CommentDAO;
import com.tms.DAO.connection.ConnectionDAO;
import com.tms.service.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends ConnectionDAO {
    private final UserService userService = new UserService();
    private final CommentDAO commentDAO = new CommentDAO();
    private final PostPattern postPattern = new PostPattern();

    public void save(Post post) {

        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into post values(default,?,?,?)");
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getDescription());
            preparedStatement.setInt(3, post.getUser().getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void approved(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update post set approved=true where id=" +id+ " ");
            preparedStatement.execute();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void notApproved(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update post set approved=false where id=" +id+ " ");
            preparedStatement.execute();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updatePost(int id, String description) {

        try {
            if(description != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("update post set description=? where id=?");
                preparedStatement.setString(1, description);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Post> findAll() {
        List<Post> postList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from post");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String description = resultSet.getString(3);
                int postOwner = resultSet.getInt(4);
                boolean approve = resultSet.getBoolean(5);
                User userByPostOwner = userService.getUserById(postOwner);
                List<Comment> commentList = commentDAO.getCommentList(new Post(id, null, null, null, null, false));
                Post post = new Post(id, title, description, userByPostOwner, commentList, approve);
                postList.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>(postList);
    }

    public void delete(int postId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from post where id="+postId+" ");
            preparedStatement.execute();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean postDataPattern(String title, String description) {
        return postPattern.postDataPattern(title, description);
    }

    public boolean postDescriptionPattern(String description) {
        return postPattern.postDescriptionPattern(description);
    }
}
