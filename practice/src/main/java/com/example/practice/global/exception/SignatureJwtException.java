package com.example.practice.global.exception;

import com.example.practice.global.error.CustomException;
import com.example.practice.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {

    public static final CustomException EXCEPTION =
             new SignatureJwtException();


    private SignatureJwtException() {
        super(ErrorCode.SIGNATURE_JWT);
    }

}
