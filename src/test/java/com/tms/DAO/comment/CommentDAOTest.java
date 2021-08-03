package com.tms.DAO.comment;

import com.tms.entity.Comment;
import com.tms.service.CommentService;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentDAOTest {
    private final CommentService commentService = new CommentService();
    public static final Logger log = LoggerFactory.getLogger(CommentDAOTest.class);

    @BeforeEach
    void start() {
        log.info("start");
    }

    @AfterEach
    void end() {
        log.info("end");
    }

    @Test
    void save() {
        log.info("testing method save in comment DAO");
        String text = "testForComment";
        Comment comment = new Comment(0, 0, text, 53, false);
        commentService.add(comment);
    }

    @Test
    @DisplayName("checking after save() comment in commentDAO")
    void checkCommentAvailable() {
        log.info("check comment list for comment available after save() new comment." +
                " Checking the getComments() method that returns a list of comments");
        List<Comment> comments = commentService.getComments();
        if (!comments.isEmpty()) {
            assertAll(
                    () -> assertFalse(comments.isEmpty()),
                    () -> assertEquals(1, comments.size()));
        } else {
            log.info("comments is empty");
        }
    }

    @Test
    @DisplayName("method approved() from commentDAO")
    void approved() {
        log.info("changing comment status from false to true");
        int id = 5;
        commentService.approveComment(id);
    }

    @Test
    void checkingApprovedMethod() {
        log.info("check comment status after approved(). " +
                "Checking the getCommentById() method that returns a comment by ID");
        int id = 5;
        Comment comment = commentService.getCommentById(id);
        if (comment != null) {
            assertTrue(comment.isApproved());
        } else {
            Exception exception = new Exception();
            log.trace(exception.getMessage());
        }
    }

    @Test
    void updateComment() {
        log.info("update comment text by comment ID");
        int id = 5;
        String newText = "new comment text";
        commentService.updateComment(id, newText);
    }

    @Test
    void checkingUpdateCommentMethod() {
        log.info("checking comment text after updateComment().");
        int id = 5;
        String newText = "new comment text";
        Comment comment = commentService.getCommentById(id);
        if (comment != null) {
            assertTrue(comment.getText().equalsIgnoreCase(newText));
        } else {
            Exception exception = new Exception();
            log.trace(exception.getMessage());
        }
    }

    @Test
    void deleteByPostId() {
        log.info("delete comment by post ID");
        int postId = 0;
        commentService.deleteCommentByPostId(postId);
    }

    @Test
    void deleteByCommentId() {
        log.info("delete comment by ID");
        int id = 5;
        commentService.deleteByCommentId(id);
    }
}