package com.example.crud.api.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostRequest {

    private String title;

    private String content;
}
