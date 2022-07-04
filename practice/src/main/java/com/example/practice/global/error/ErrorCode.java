package com.example.practice.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode{
    AUTH_NOT_FOUND(404, "Auth Not Found");

    private final int status;
    private final String message;

}
