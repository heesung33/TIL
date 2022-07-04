package com.example.practice.domain.auth.domain.repository;

import com.example.practice.domain.auth.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth>findByAccountId(String accountId);
}
