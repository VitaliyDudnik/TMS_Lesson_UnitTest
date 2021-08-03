package com.tms.service;

import com.tms.entity.User;
import com.tms.DAO.user.UserDAO;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public boolean add(User user) {
        if (userDAO.existsByUsername(user.getUsername())) {
            return false;
        } else {
            userDAO.save(user);
            return true;
        }
    }

    public List<User> getAll() {
        return userDAO.findAll();
    }

    public boolean findByUsername(String username) {
       return userDAO.existsByUsername(username);
    }


    public void updateUsername(User user, String username) {
        userDAO.updateUsernameById(user, username);
    }

    public void updatePassword(User user, String password) {
        userDAO.updatePasswordById(user, password);
    }

    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

    public boolean existById(int id) {
        return userDAO.existsById(id);
    }

    public void deleteByUsername(String username) {
        userDAO.deleteByUsername(username);
    }

    public User getByUsername(String username) {
        return userDAO.getByUsername(username);
    }
    public User getUserById(int id){
        return userDAO.getUserById(id);
    }

    public boolean validPassUname(String password, String username) {
        return userDAO.validPassUname(password, username);
    }

    public boolean validUname(String username) {
        return userDAO.validUsername(username);
    }

    public boolean validPass(String password) {
        return userDAO.validPass(password);
    }

    public boolean validUserData(String name, String username, String password){
        return userDAO.validUserData(name, username, password);
    }
}
