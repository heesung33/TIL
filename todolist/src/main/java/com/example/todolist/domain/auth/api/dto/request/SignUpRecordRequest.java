package com.example.todolist.domain.auth.api.dto.request;

import javax.validation.constraints.NotBlank;

public record SignUpRecord(
        @NotBlank String email,
        @NotBlank String password,
        @NotBlank String name
) {
}
