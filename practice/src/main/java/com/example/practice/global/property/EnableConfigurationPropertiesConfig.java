package com.example.practice.global.property;

import com.example.practice.global.security.jwt.JwtProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {JwtProperty.class})
@Configuration
public class EnableConfigurationPropertiesConfig {
}
