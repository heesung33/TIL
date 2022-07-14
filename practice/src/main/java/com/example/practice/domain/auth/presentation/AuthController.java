package com.example.practice.domain.auth.presentation;


import com.example.practice.domain.auth.presentation.dto.request.SignInRequest;
import com.example.practice.domain.auth.service.SignInService;
import com.example.practice.domain.auth.service.SignUpService;
import com.example.practice.domain.auth.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
    }

    @PostMapping("/signin")
    public void signin(@RequestBody @Valid SignInRequest signInRequest) {
        signInService.execute(signInRequest);
    }
}
