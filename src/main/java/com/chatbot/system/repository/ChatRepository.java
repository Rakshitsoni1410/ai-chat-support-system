package com.chatbot.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatbot.system.model.ChatMessage;

public interface ChatRepository extends JpaRepository<ChatMessage, Long> {

    List<ChatMessage> findByUserId(Long userId);
}