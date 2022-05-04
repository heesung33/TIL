package com.example.crud.controller.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostRequest {

    private String title;

    private String content;
}
