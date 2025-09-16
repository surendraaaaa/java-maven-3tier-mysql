package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        userService.registerUser(new User(0, "John Doe", "john@example.com"));
        List<User> users = userService.listUsers();
        for (User u : users) {
            System.out.println(u.getId() + " | " + u.getName() + " | " + u.getEmail());
        }
    }
}