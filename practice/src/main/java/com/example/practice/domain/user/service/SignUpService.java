package com.example.practice.domain.user.service;

import com.example.practice.domain.user.domain.User;
import com.example.practice.domain.user.domain.repository.UserRepository;
import com.example.practice.domain.user.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest signUpRequest) {

        User user = User.builder()
                .accountId(signUpRequest.getAccountId())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .userName(signUpRequest.getUserName())
                .build();

        userRepository.save(user);
    }
}
