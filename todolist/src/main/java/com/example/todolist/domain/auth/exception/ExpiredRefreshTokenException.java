package com.example.todolist.domain.auth.exception;

import com.example.todolist.global.error.ErrorCode;
import com.example.todolist.global.error.exception.SnsException;

public class ExpiredRefreshTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new ExpiredRefreshTokenException();

    private ExpiredRefreshTokenException() {
        super(ErrorCode.EXPIRED_REFRESH_TOKEN);
    }
}
