package com.example.practice.global.error.ErrorReponse;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CustomErrorResponse {

    private final int status;
    private final String message;
}
