package com.example.todolist.domain.todolist.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ToDoResponse {
    private final String title;
    private final String content;
}
