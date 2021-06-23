package com.example.swaggerdemo.repository;

import com.example.swaggerdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
