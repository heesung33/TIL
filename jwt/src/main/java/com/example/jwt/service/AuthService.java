package com.example.jwt.service;

import com.example.jwt.payload.LoginRequest;
import com.example.jwt.payload.SignupRequest;
import com.example.jwt.payload.TokenResponse;

public interface AuthService {
    void signup(SignupRequest signupRequest);
    TokenResponse signin(LoginRequest loginRequest);
    TokenResponse reissue(String token);
}
