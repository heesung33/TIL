package com.example.crud.controller.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class PostRequest {

    private String title;

    private String content;
}
