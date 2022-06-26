package com.example.todolist.domain.auth.api.dto.response;


import javax.validation.constraints.NotBlank;

public record TokenRecordResponse(
        @NotBlank String accessToken,
        @NotBlank String refreshToken
) {
}
