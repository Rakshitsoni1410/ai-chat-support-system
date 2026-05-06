package com.chatbot.system.service;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String getResponse(String message) {

        message = message.toLowerCase();

        if (message.contains("hello") || message.contains("hi")) {
            return "Hello! How can I help you today?";
        }

        if (message.contains("refund")) {
            return "Refund will be processed in 5-7 working days.";
        }

        if (message.contains("order")) {
            return "Your order is being processed and will be delivered soon.";
        }

        if (message.contains("login")) {
            return "Please use forgot password option to reset login.";
        }

        return "Sorry, I didn't understand. Please contact support.";
    }
}