package com.example.dao;

import com.example.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDao {
    private Connection connection;

    public UserDao() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getEmail());
        stmt.executeUpdate();
    }

    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
        }
        return users;
    }
}