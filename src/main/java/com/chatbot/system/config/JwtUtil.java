package com.chatbot.system.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "mysecretkeymysecretkeymysecretkeymysecretkey12345";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // GENERATE TOKEN
    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // EXTRACT EMAIL
    public String extractUsername(String token) {

        return getClaims(token).getSubject();
    }

    // VALIDATE TOKEN
    public boolean validateToken(String token) {

        try {

            return getClaims(token)
                    .getExpiration()
                    .after(new Date());

        } catch (Exception e) {

            return false;
        }
    }

    // GET CLAIMS
    private Claims getClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}