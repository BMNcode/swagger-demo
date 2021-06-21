package com.example.swaggerdemo.controller;

import com.example.swaggerdemo.model.Message;
import com.example.swaggerdemo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public List<Message> getAllMessage () {
        return messageRepository.findAll();
    }

    @PostMapping
    public Message create (@RequestBody Message message) {
        return messageRepository.save(message);
    }
}

