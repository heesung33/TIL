package com.example.jwt.exception;

public class IncorrectTokenException extends BusinessException {
    public IncorrectTokenException() {
        super(ErrorCode.INCORRECT_TOKEN);
    }
}