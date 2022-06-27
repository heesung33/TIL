package com.example.todolist.domain.post.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PostResponse {
    private final String title;
    private final String content;
}
