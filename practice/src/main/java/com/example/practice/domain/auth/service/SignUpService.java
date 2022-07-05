package com.example.practice.domain.auth.service;

import com.example.practice.domain.auth.domain.Auth;
import com.example.practice.domain.auth.domain.Role;
import com.example.practice.domain.auth.domain.repository.AuthRepository;
import com.example.practice.domain.auth.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final AuthRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest signUpRequest) {

        Auth auth = Auth.builder()
                .accountId(signUpRequest.getAccountId())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .name(signUpRequest.getName())
                .role(Role.USER)
                .build();

        userRepository.save(auth);
    }
}
