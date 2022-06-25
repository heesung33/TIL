package com.example.todolist.domain.auth.service;


import com.example.todolist.domain.auth.api.dto.request.SignUpRecordRequest;
import com.example.todolist.domain.auth.domain.User;
import com.example.todolist.domain.auth.domain.repository.UserRepository;
import com.example.todolist.domain.auth.domain.types.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRecordRequest signUpRecordRequest) {
        userRepository.save(
                User.builder()
                    .email(signUpRecordRequest.email())
                    .password(passwordEncoder.encode(signUpRecordRequest.password()))
                    .name(signUpRecordRequest.name())
                    .role(Role.ROLE_USER)
                .build());
    }
}
