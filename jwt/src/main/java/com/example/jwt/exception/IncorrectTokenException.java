package com.example.jwt.exception;

public class IncorrectTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new IncorrectTokenException();


    private IncorrectTokenException() {
        super(ErrorCode.INCORRECT_TOKEN);
    }
}