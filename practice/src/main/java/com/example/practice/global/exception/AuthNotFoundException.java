package com.example.practice.global.exception;

import com.example.practice.global.error.CustomException;
import com.example.practice.global.error.ErrorCode;

public class AuthNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new AuthNotFoundException();

    private AuthNotFoundException() {
        super(ErrorCode.AUTH_NOT_FOUND);
    }
}
