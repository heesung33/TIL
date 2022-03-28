package com.example.crud.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostsResponse {

    private String title;
    private String content;
}
