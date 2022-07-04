package com.example.practice.global.security.auth;


import com.example.practice.domain.auth.domain.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AuthDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        return authRepository.findByAccountId(accountId)
                .map(AuthDetails::new)
                .orElseThrow(() -> AuthNotFoundException.EXCEPTION);
    }
}
