package com.example.jwt.service;

import com.example.jwt.entity.refreshtoken.RefreshToken;
import com.example.jwt.entity.refreshtoken.RefreshTokenRepository;
import com.example.jwt.entity.user.Role;
import com.example.jwt.entity.user.User;
import com.example.jwt.entity.user.UserRepository;
import com.example.jwt.exception.InvalidPasswordException;
import com.example.jwt.exception.InvalidTokenException;
import com.example.jwt.exception.RefreshTokenNotFoundException;
import com.example.jwt.exception.UserNotFoundException;
import com.example.jwt.jwt.JwtTokenProvider;
import com.example.jwt.payload.LoginRequest;
import com.example.jwt.payload.SignupRequest;
import com.example.jwt.payload.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    @Value("${jwt.exp.refresh}")
    private Long REFRESH_TOKEN_EXPIRATION_TIME;

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequest signupRequest) {
        userRepository.save(User.builder()
                .name(signupRequest.getName())
                .username(signupRequest.getUsername())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .role(Role.ROLE_USER)
                .build());
    }

    @Transactional
    public TokenResponse signin(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
            throw InvalidPasswordException.EXCEPTTION;

        return createToken(loginRequest.getUsername());
    }

    @Transactional
    public TokenResponse createToken(String username) {
        String accessToken = tokenProvider.createAccessToken(username);
        String refreshToken = tokenProvider.createRefreshToken(username);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .username(username)
                        .refreshToken(refreshToken)
                        .refreshExpiration(REFRESH_TOKEN_EXPIRATION_TIME)
                        .build());

        return new TokenResponse(accessToken, refreshToken);
    }

    @Override
    @Transactional
    public TokenResponse reissue(String refreshToken) {
        if(!tokenProvider.isRefreshToken(refreshToken)) {
            throw InvalidTokenException.EXCEPTION;
        }

        RefreshToken newRefreshToken = refreshTokenRepository.findByRefreshToken(refreshToken)
                .map(refresh -> refreshTokenRepository.save(
                        refresh.update(REFRESH_TOKEN_EXPIRATION_TIME)
                ))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        return new TokenResponse(tokenProvider.createAccessToken(newRefreshToken.getUsername()), refreshToken);
    }
}
