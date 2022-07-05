package com.example.practice.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode{
    PASSWORD_MISMATCH(401, "Password MisMatch"),
    EXPIRED_JWT(401, "Expired Jwt"),
    AUTH_NOT_FOUND(404, "Auth Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SIGNATURE_JWT(401, "Signature Jwt"),
    INVALID_JWT(401, "Invalid Jwt");

    private final int status;
    private final String message;

}
