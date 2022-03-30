package com.example.jwt.exception;

public class RefreshTokenNotFoundException extends BusinessException {

    public static BusinessException EXCEPTION =
            new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException(){
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
