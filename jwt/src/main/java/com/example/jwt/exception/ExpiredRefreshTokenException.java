package com.example.jwt.exception;

public class ExpiredRefreshTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new ExpiredRefreshTokenException();

    private ExpiredRefreshTokenException(){
        super(ErrorCode.EXPIRED_REFRESH_TOKEN);
    }

}
