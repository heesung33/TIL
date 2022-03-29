package com.example.jwt.payload;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequest {

    private String name;

    private String username;

    private String password;

}
