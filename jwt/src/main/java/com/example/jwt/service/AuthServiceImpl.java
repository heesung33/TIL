package com.example.jwt.service;

import com.example.jwt.entity.Role;
import com.example.jwt.entity.User;
import com.example.jwt.entity.repository.UserRepository;
import com.example.jwt.payload.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequest signupRequest) {
        userRepository.save(User.builder()
                .name(signupRequest.getName())
                .username(signupRequest.getUsername())
                .password(passwordEncoder.encode(signupRequest.getPassword()))
                .role(Role.ROLE_USER)
                .build());
    }
}
