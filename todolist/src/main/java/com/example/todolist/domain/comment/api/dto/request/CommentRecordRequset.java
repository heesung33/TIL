package com.example.todolist.domain.comment.api.dto.request;


import javax.validation.constraints.NotBlank;


public record CommentRecordRequset(
        @NotBlank String content
) {
}
