package com.example.swaggerdemo.repository;

import com.example.swaggerdemo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
