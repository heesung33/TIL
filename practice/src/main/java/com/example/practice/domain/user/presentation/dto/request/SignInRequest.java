package com.example.practice.domain.user.presentation.dto.request;

import lombok.Getter;

@Getter
public class SignInRequest {
    private String accountId;
    private String password;
}
