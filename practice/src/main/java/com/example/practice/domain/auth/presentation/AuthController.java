package com.example.practice.domain.auth.presentation;


import com.example.practice.domain.auth.service.SignUpService;
import com.example.practice.domain.auth.presentation.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class AuthController {

    private final SignUpService signUpService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRequest signUpRequest) {
        signUpService.execute(signUpRequest);
    }
}
