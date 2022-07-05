package com.example.practice.domain.auth.service;

import com.example.practice.domain.auth.domain.Auth;
import com.example.practice.domain.auth.domain.Role;
import com.example.practice.domain.auth.domain.repository.AuthRepository;
import com.example.practice.domain.auth.exception.PasswordMisMatchException;
import com.example.practice.domain.auth.presentation.dto.request.SignInRequest;
import com.example.practice.domain.auth.presentation.dto.response.TokenResponse;
import com.example.practice.global.exception.AuthNotFoundException;
import com.example.practice.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class SignInService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public TokenResponse execute(SignInRequest request) {
        return signIn(request, Role.USER);
    }


    private TokenResponse signIn(SignInRequest request, Role role) {
        Auth auth = authRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> AuthNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), auth.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        TokenResponse tokenResponse = jwtTokenProvider.generateTokens(request.getAccountId(), role);

        return TokenResponse.builder()
                .accessToken(tokenResponse.getAccessToken())
                .refreshToken(tokenResponse.getRefreshToken())
                .build();
    }


}
