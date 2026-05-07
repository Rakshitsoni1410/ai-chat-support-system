package com.chatbot.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbot.system.model.ChatMessage;
import com.chatbot.system.repository.ChatRepository;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    // Save chat
    public ChatMessage saveChat(ChatMessage chat) {
        return chatRepository.save(chat);
    }

    // Get history
    public List<ChatMessage> getChatHistory(Long userId) {
        return chatRepository.findByUserId(userId);
    }
}