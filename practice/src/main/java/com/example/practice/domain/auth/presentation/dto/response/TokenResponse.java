package com.example.practice.domain.auth.presentation.dto.response;

import lombok.Getter;

@Getter
public class TokenResponse {
    private String accessToken;
    private String refreshToken;

}
