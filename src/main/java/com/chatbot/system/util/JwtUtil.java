package com.chatbot.system.util;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        return "dummy-token-" + username;
    }

    public String extractUsername(String token) {
        return token.replace("dummy-token-", "");
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("dummy-token-");
    }
}