package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // allow frontend
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Save new user
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        userRepository.flush(); // ensure ID is generated
        return savedUser;
    }

    // Get all users (optional, for testing)
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}


