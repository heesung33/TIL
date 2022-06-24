package com.example.todolist.domain.todolist.api.dto.request;


import javax.validation.constraints.NotBlank;

public record CommentRecord(
        @NotBlank String content
) {
}
