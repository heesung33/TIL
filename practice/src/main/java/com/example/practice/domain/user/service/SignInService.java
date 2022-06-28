package com.example.practice.domain.user.service;

import com.example.practice.domain.user.domain.User;
import com.example.practice.domain.user.domain.repository.UserRepository;
import com.example.practice.domain.user.presentation.dto.request.SignInRequest;
import com.example.practice.domain.user.presentation.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse excute(SignInRequest signInRequest) {
        User user = userRepository.findByAccountId(signInRequest.getAccountId())
                .orElseThrow(RuntimeException::new);

        if(!passwordEncoder.matches(signInRequest.getPassword(), signInRequest.getPassword()))
            throw new RuntimeException();

        TokenResponse tokenResponse =
    }


}
