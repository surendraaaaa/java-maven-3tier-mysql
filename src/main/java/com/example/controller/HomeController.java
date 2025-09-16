package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Welcome to My Java + MySQL App 🚀");
        model.addAttribute("message", "This is running on Spring Boot and Docker!");
        return "home"; // This refers to src/main/resources/templates/home.html
    }

    @GetMapping("/home")
    public String hello(Model model) {
        model.addAttribute("greeting", "Hello from the backend!");
        return "hello"; // This refers to src/main/resources/templates/hello.html
    }
}

