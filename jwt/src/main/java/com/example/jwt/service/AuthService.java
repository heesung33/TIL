package com.example.jwt.service;

import com.example.jwt.payload.SignupRequest;

public interface AuthService {
    void signup(SignupRequest signupRequest);

}
