package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public void registerUser(User user) throws SQLException {
        userDao.addUser(user);
    }

    public List<User> listUsers() throws SQLException {
        return userDao.getUsers();
    }
}