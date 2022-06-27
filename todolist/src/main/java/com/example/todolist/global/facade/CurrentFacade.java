package com.example.todolist.global.facade;

import com.example.todolist.domain.auth.domain.User;
import com.example.todolist.domain.auth.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CurrentFacade {

    private final UserRepository authRepository;

    public User getCurrentUser() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return authRepository.findById(getCurrentUser().getId())
                .orElseThrow(() -> new RuntimeException());
    }
}
