package com.tms.DAO.comment;

import com.tms.entity.Comment;
import com.tms.entity.Post;
import com.tms.entity.User;
import com.tms.DAO.connection.ConnectionDAO;
import com.tms.service.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends ConnectionDAO {
    private final UserService userService = new UserService();

    public void save(Comment comment) {

        try {
            connection.setAutoCommit(false);
            if ( comment != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into comment values (default ,?,?,?,?)");
                preparedStatement.setString(1, comment.getText());
                preparedStatement.setInt(2, comment.getUserId());
                preparedStatement.setInt(3, comment.getPostId());
                preparedStatement.setBoolean(4, comment.isApproved());
                preparedStatement.execute();
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
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
            PreparedStatement preparedStatement = connection.prepareStatement("update comment set approved = true where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public void updateComment(int id, String text) {

        try {
            if (text != null & !text.trim().isEmpty()) {
                PreparedStatement preparedStatement = connection.prepareStatement("update comment set text = ? where id = ?");
                preparedStatement.setString(1, text);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Comment> getCommentList(Post post) {
        List<Comment> commentList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from comment");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String text = resultSet.getString(2);
                int userId = resultSet.getInt(3);
                int postId = resultSet.getInt(4);
                boolean approve = resultSet.getBoolean(5);
                User userById = userService.getUserById(userId);
                commentList.add(new Comment(id, postId, text, userById, approve));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>(commentList);
    }

    public List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from comment");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String text = resultSet.getString(2);
                int userId = resultSet.getInt(3);
                int postId = resultSet.getInt(4);
                boolean approve = resultSet.getBoolean(5);
                User userById = userService.getUserById(userId);
                comments.add(new Comment(id, postId, text, userById, approve));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>(comments);
    }

    public void deleteByPostId(int postId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from comment where post_id=" + postId + "");
            preparedStatement.execute();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteByCommentId(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from comment where id=" + id + "");
            preparedStatement.execute();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public Comment getCommentById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from comment where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int num = resultSet.getInt(1);
            String text = resultSet.getString(2);
            int userId = resultSet.getInt(3);
            int postId = resultSet.getInt(4);
            boolean approve = resultSet.getBoolean(5);

            return new Comment(num, postId, text, userId, approve);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}


