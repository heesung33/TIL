package com.example.jwt.exception;

public class InvalidTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }
}

