package com.chatbot.system.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.chatbot.system.model.ChatMessage;
import com.chatbot.system.repository.ChatRepository;
import com.chatbot.system.service.ChatbotService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatbotService chatbotService;

    @Autowired
    private ChatRepository chatRepository;

    // =========================
    // SEND MESSAGE (JWT SECURED)
    // =========================
    @PostMapping("/send")
    public ChatMessage sendMessage(
            @RequestParam String message,
            Authentication authentication
    ) {

        // 👇 username comes from JWT (NOT frontend)
        String username = authentication.getName();

        String response = chatbotService.getResponse(message);

        ChatMessage chat = new ChatMessage();
        chat.setUserId(0L); // optional OR replace with DB lookup
        chat.setMessage(message);
        chat.setResponse(response);
        chat.setTimestamp(LocalDateTime.now());

        return chatRepository.save(chat);
    }

    // =========================
    // HISTORY
    // =========================
    @GetMapping("/history/{userId}")
    public List<ChatMessage> history(@PathVariable Long userId) {
        return chatRepository.findByUserId(userId);
    }
}