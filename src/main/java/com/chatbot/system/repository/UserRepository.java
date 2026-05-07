package com.chatbot.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatbot.system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}