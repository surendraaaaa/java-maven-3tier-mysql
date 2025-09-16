package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<Map<String, String>> getUsers() {
        List<Map<String, String>> users = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://mysql:3306/testdb", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, email FROM users");
            while (rs.next()) {
                users.add(Map.of(
                    "id", rs.getString("id"),
                    "name", rs.getString("name"),
                    "email", rs.getString("email")
                ));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

