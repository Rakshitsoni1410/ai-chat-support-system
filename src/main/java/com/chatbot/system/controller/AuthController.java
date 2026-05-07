package com.chatbot.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chatbot.system.dto.LoginRequest;
import com.chatbot.system.dto.RegisterRequest;
import com.chatbot.system.model.User;
import com.chatbot.system.service.UserService;
import com.chatbot.system.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER");

        return userService.registerUser(user);
    }

    // LOGIN
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        boolean isValid = userService.loginUser(
                request.getEmail(),
                request.getPassword()
        );

        Map<String, String> response = new HashMap<>();

        if (isValid) {
            String token = jwtUtil.generateToken(request.getEmail());
            response.put("token", token);
            return response;
        }

        response.put("error", "Invalid credentials");
        return response;
    }
}