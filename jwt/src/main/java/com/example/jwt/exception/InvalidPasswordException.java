package com.example.jwt.exception;

public class InvalidPasswordException extends BusinessException {

    public static BusinessException EXCEPTTION =
            new InvalidPasswordException();


    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
