package com.example.todolist.domain.auth.exception;

import com.example.todolist.global.error.ErrorCode;
import com.example.todolist.global.error.exception.SnsException;

public class ExpiredAccessTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new ExpiredAccessTokenException();

    private ExpiredAccessTokenException() {
        super(ErrorCode.EXPIRED_ACCESS_TOKEN);
    }
}
