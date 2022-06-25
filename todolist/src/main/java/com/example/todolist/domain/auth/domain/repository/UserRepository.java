package com.example.todolist.domain.auth.domain.repository;

import com.example.todolist.domain.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
