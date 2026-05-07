package com.chatbot.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chatbot.system.dto.LoginRequest;
import com.chatbot.system.dto.RegisterRequest;
import com.chatbot.system.model.User;
import com.chatbot.system.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // =========================
    // REGISTER API
    // =========================
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        return userService.registerUser(user);
    }

    // =========================
    // LOGIN API
    // =========================
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        boolean isValid = userService.loginUser(
                request.getEmail(),
                request.getPassword()
        );

        if (isValid) {
            return "Login Successful";
        }

        return "Invalid Email or Password";
    }
}