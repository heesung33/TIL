package com.example.todolist.domain.post.api.dto.request;

import javax.validation.constraints.NotBlank;

public record PostRecord(
        @NotBlank String title,
        @NotBlank String content
) {
}
