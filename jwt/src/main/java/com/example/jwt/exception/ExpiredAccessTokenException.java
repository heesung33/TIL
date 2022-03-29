package com.example.jwt.exception;

public class ExpiredAccessTokenException extends BusinessException {
    public ExpiredAccessTokenException() {
        super(ErrorCode.EXPIRED_ACCESS_TOKEN);
    }
}
