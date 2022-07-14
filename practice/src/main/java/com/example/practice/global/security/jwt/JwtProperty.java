package com.example.practice.global.security.jwt;


import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
public class JwtProperty {

    private final JwtExp exp;

    private final String secretKey;



    @Getter
    @AllArgsConstructor
    public static class JwtExp {
        private final Long access;
        private final Long refresh;
    }
    public JwtProperty(String secretKey) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.exp = getExp();
    }
}
