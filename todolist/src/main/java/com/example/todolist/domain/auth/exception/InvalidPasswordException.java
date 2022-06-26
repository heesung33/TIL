package com.example.todolist.domain.auth.exception;

import com.example.todolist.global.error.ErrorCode;
import com.example.todolist.global.error.exception.SnsException;

public class InvalidPasswordException extends SnsException {
    public static SnsException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
