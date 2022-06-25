package com.example.todolist.domain.comment.api.dto.request;


import javax.validation.constraints.NotBlank;

public record CommentRecord(
        @NotBlank String content
) {
}
