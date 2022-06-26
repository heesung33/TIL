package com.example.todolist.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_PASSWORD(401,"Invalid password"),
    EXPIRED_ACCESS_TOKEN(401, "Expired Access Token"),
    EXPIRED_REFRESH_TOKEN(401,"Expired Refresh Token"),
    INVALID_TOKEN(401,"Invalid Token"),
    INCORRECT_TOKEN(500,"Incrrect Token"),
    USER_NOT_FOUND(404, "user not found");

    private final int status;
    private final String message;

}
