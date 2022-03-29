package com.example.jwt.controller;


import com.example.jwt.payload.LoginRequest;
import com.example.jwt.payload.SignupRequest;
import com.example.jwt.payload.TokenResponse;
import com.example.jwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest signupRequest) {
        authService.signup(signupRequest);
    }

    @PostMapping("/signin")
    public TokenResponse signin(@RequestBody LoginRequest loginRequest) {
        return authService.signin(loginRequest);
    }

    @PutMapping("reissue")
    public TokenResponse reissue(@RequestHeader(name = "x-refresh-token") String token) {
        return authService.reissue(token);
    }
}
