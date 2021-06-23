package com.example.swaggerdemo.controller;

import com.example.swaggerdemo.model.User;
import com.example.swaggerdemo.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Operation(summary = "create user")
    @GetMapping
    public List<User> getAllUser () {
        return userRepository.findAll();
    }

    @Operation(summary = "get all user")
    @PostMapping
    public User save (@RequestBody User user) {
        return userRepository.save(user);
    }
}
