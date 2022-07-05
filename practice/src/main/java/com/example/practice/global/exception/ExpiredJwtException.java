package com.example.practice.global.exception;

import com.example.practice.global.error.CustomException;
import com.example.practice.global.error.ErrorCode;

public class ExpiredJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new ExpiredJwtException();


    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }

}
