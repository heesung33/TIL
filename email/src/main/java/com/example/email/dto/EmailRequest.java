package com.example.email.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailRequest {
    private String title;
    private String text;
    private String email;
}
