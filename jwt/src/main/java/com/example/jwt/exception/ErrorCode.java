package com.example.jwt.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    EXPIRED_REFRESH_TOKEN(401, "Expired Refresh Token"),
    REFRESH_TOKEN_NOT_FOUND(404, "Refresh Token Not Found"),
    INCORRECT_TOKEN(400, "Incorrect Token"),
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_ACCESS_TOKEN(401, "Expired Access Token"),
    USER_NOT_FOUND(404, "User Not Found"),
    INVALID_PASSWORD(401, "Invalid Password");
    private final int status;
    private final String message;
}
