package com.example.practice.domain.auth.service;

import com.example.practice.domain.auth.domain.Auth;
import com.example.practice.domain.auth.domain.repository.AuthRepository;
import com.example.practice.domain.auth.presentation.dto.request.SignInRequest;
import com.example.practice.domain.auth.presentation.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class SignInService {

    private final AuthRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenResponse excute(SignInRequest signInRequest) {
        Auth user = userRepository.findByAccountId(signInRequest.getAccountId())
                .orElseThrow(RuntimeException::new);

        if(!passwordEncoder.matches(signInRequest.getPassword(), signInRequest.getPassword()))
            throw new RuntimeException();

        TokenResponse tokenResponse =
    }


}
