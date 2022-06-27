package com.example.todolist.domain.post.api.dto.request;

import javax.validation.constraints.NotBlank;

public record ToDoRecord(
        @NotBlank String title,
        @NotBlank String content
) {
}
