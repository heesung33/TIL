package com.example.todolist.domain.auth.api.dto.request;

import javax.validation.constraints.NotBlank;

public record SignInRecordRequest(
        @NotBlank String email,
        @NotBlank String password
) {
}
