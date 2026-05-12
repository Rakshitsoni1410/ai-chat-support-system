package com.chatbot.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.system.config.JwtUtil;
import com.chatbot.system.dto.LoginRequest;
import com.chatbot.system.dto.RegisterRequest;
import com.chatbot.system.model.User;
import com.chatbot.system.service.UserService;

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

        System.out.println("LOGIN API CALLED");

        boolean isValid = userService.loginUser(
                request.getEmail(),
                request.getPassword()
        );

        Map<String, String> response = new HashMap<>();

        if (isValid) {

            String token = jwtUtil.generateToken(request.getEmail());

            System.out.println("TOKEN => " + token);

            response.put("token", token);

            return response;
        }

        response.put("error", "Invalid credentials");

        return response;
    }
}