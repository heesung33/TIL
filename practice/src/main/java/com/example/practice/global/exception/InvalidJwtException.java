package com.example.practice.global.exception;

import com.example.practice.global.error.CustomException;
import com.example.practice.global.error.ErrorCode;

public class InvalidJwtException extends CustomException {
    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }

}
