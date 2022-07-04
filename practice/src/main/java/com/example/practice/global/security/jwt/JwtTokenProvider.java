package com.example.practice.global.security.jwt;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private static final String ACCESS_KEY = "access";
    private static final String REFRESH_KEY = "refresh";
    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    private final JwtProperty jwtProperty;





}
