package com.example.todolist.domain.auth.api;

import com.example.todolist.domain.auth.api.dto.request.SignInRecordRequest;
import com.example.todolist.domain.auth.api.dto.request.SignUpRecordRequest;
import com.example.todolist.domain.auth.api.dto.response.TokenRecordResponse;
import com.example.todolist.domain.auth.service.AuthSignInService;
import com.example.todolist.domain.auth.service.AuthSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthSignUpService authSignUpService;
    private final AuthSignInService authSignInService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignUpRecordRequest signUpRecordRequest) {
        authSignUpService.execute(signUpRecordRequest);
    }

    @PostMapping("/signin")
    public TokenRecordResponse signin(@RequestBody SignInRecordRequest signInRecordRequest){
        return authSignInService.excute(signInRecordRequest);
    }
}
