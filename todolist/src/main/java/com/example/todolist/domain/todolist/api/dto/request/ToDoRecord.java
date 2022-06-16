package com.example.todolist.domain.todolist.api.dto.request;

import javax.validation.constraints.NotBlank;

public record ToDoRecord(
        @NotBlank String title,
        @NotBlank String content
) {
}
