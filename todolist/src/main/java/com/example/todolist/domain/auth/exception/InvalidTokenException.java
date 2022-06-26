package com.example.todolist.domain.auth.exception;

import com.example.todolist.global.error.ErrorCode;
import com.example.todolist.global.error.exception.SnsException;

public class InvalidTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
