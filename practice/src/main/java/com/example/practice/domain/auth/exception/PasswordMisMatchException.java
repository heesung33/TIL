package com.example.practice.domain.auth.exception;

import com.example.practice.global.error.CustomException;
import com.example.practice.global.error.ErrorCode;

public class PasswordMisMatchException extends CustomException {

    public static final PasswordMisMatchException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
