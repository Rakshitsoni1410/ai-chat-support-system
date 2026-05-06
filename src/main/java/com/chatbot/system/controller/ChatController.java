package com.chatbot.system.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/send")
    public ChatMessage sendMessage(@RequestParam Long userId,
                                   @RequestParam String message) {

        String response = chatbotService.getResponse(message);

        ChatMessage chat = new ChatMessage();
        chat.setUserId(userId);
        chat.setMessage(message);
        chat.setResponse(response);
        chat.setTimestamp(LocalDateTime.now());

        return chatRepository.save(chat);
    }

    @GetMapping("/history/{userId}")
    public List<ChatMessage> history(@PathVariable Long userId) {
        return chatRepository.findByUserId(userId);
    }
}