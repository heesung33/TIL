package com.example.todolist.domain.auth.service;

import com.example.todolist.domain.auth.api.dto.request.SignInRecordRequest;
import com.example.todolist.domain.auth.api.dto.response.TokenRecordResponse;
import com.example.todolist.domain.auth.domain.RefreshToken;
import com.example.todolist.domain.auth.domain.User;
import com.example.todolist.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.todolist.domain.auth.domain.repository.UserRepository;
import com.example.todolist.domain.auth.exception.InvalidPasswordException;
import com.example.todolist.domain.auth.exception.UserNotFoundException;
import com.example.todolist.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class AuthSignInService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.exp.refresh}")
    private Long REFRESH_TOKEN_VALID_TIME;

    public TokenRecordResponse excute(SignInRecordRequest signInRecordRequest) {
        User user =
                userRepository.findByEmail(signInRecordRequest.email())
                        .orElseThrow(()-> UserNotFoundException.EXCEPTION);
        if (!passwordEncoder.matches(signInRecordRequest.password(), user.getPassword()))
            throw InvalidPasswordException.EXCEPTION;

        return createToken(signInRecordRequest.email());
    }

    public TokenRecordResponse createToken(String name) {
        String accessToken = jwtTokenProvider.createJwtAccessToken(name);
        String refreshToken = jwtTokenProvider.createJwtRefreshToken(name);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .userName(name)
                        .refreshToken(refreshToken)
                        .refreshExpiration(REFRESH_TOKEN_VALID_TIME)
                        .build());

        return new TokenRecordResponse(accessToken, refreshToken);
    }

}
