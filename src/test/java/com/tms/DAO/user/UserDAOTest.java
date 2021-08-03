package com.tms.DAO.user;

import com.tms.entity.Role;
import com.tms.entity.User;
import com.tms.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class UserDAOTest  {
    private final UserService userService = new UserService();
    static List<User> usersList = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(UserDAOTest.class);
    private User user;

    @Test
    @DisplayName("Check save() and getAll() in userService-userDAO")
    void save() {
        insertUsersInDAO();
        usersList = userService.getAll();
        Assertions.assertFalse(usersList.isEmpty(), "size of users table will be not null");
    }

    void insertUsersInDAO() {
        userService.add(new User(0, "name", "test", "testpass", Role.USER));
    }

    @Test
    @DisplayName("Test findAll() in userDAO")
    void findAll() {
        usersList = userService.getAll();
        Assertions.assertEquals(2, usersList.size(), "expected true, size of userList");
    }

    @Test
    @DisplayName("checking update username in userDAO")
    void updateUsernameById() {
        String actualUsername = "username";
        String newUsername = "newUsername";
        user = userService.getByUsername(actualUsername);
        userService.updateUsername(user, newUsername);
    }

    @Test
    @DisplayName("Update password in DAO by user id")
    void updatePasswordById() {
        log.info("update password in DAO");

        String actualUsername = "newUsername";
        String newPassword = "newPassword";

        user = userService.getByUsername(actualUsername);
        userService.updatePassword(user, newPassword);
    }

    @Test
    void checkingForNewPassword() {
        String newPassword = "newPassword";
        String actualUsername = "newUsername";
        user = userService.getByUsername(actualUsername);

        Assertions.assertAll("user new password",
                () -> Assertions.assertEquals(actualUsername, user.getUsername()),
                () -> Assertions.assertEquals(newPassword, user.getPassword()));

        log.info("password has been changed");

    }

    @Test
    @DisplayName("checking user in DAO by ID")
    void getUserById() {
        int id = 31;
        user = userService.getUserById(id);
        if (user != null) {
            Assertions.assertAll("check user from DAO by ID",
                    () -> Assertions.assertEquals("Vitaliy", user.getName()),
                    () -> Assertions.assertEquals("Vitaliy", user.getUsername()));
        } else {
            log.error("user is null");
        }
    }

    @Test
    @DisplayName("delete user from DAO by ID")
    void deleteById() {
        int id = 31;
        userService.deleteById(id);
    }

    @Test
    void checkingIfUserExistsAfterDelete() {
        log.info("Start checking after delete by ID");
        int id = 31;
        Assertions.assertFalse(userService.existById(id), "expected user null");
    }

    @Test
    @DisplayName("checking if user exists in DAO by user ID")
    void existsById() {

        log.info("checking if user exists in DAO by user ID");
        int id = 0;
        String actualUsername = "newUsername";
        User user = userService.getByUsername(actualUsername);
        if (user != null) id = user.getId();

        Assertions.assertTrue(userService.existById(id), "expected exists userById");
    }

    @Test
    @DisplayName("checking if user with new username exists in DAO")
    void existsByUsername() {
        log.info("checking if user with new username exists in DAO...");

        String actualName = "name";
        String newUsername = "newUsername";
        String actualPassword = "newPassword";
        User user = userService.getByUsername(newUsername);

        Assertions.assertAll("user",
                () -> Assertions.assertEquals(newUsername, user.getUsername()),
                () -> Assertions.assertEquals(actualName, user.getName()),
                () -> Assertions.assertEquals(actualPassword, user.getPassword()));

    }

    @Test
    @DisplayName("checking user data regex patterns")
    void validUserData() {
        Pattern name = Pattern.compile("(?=\\S+$).{2,16}");
        Pattern username = Pattern.compile("(?=\\S+$).{2,16}");
        Pattern password = Pattern.compile("(?=.*[0-9])(?=\\S+$).{5,20}");
        Matcher matcherName = name.matcher("vitaliy");
        Matcher matcherUsername = username.matcher("vitaliy");
        Matcher matcherPassword = password.matcher("yyy78yyy");
        Assertions.assertAll("user data patterns check",
                () -> Assertions.assertTrue(matcherName.find()),
                () -> Assertions.assertTrue(matcherUsername.find()),
                () -> Assertions.assertTrue(matcherPassword.find()));
    }
}