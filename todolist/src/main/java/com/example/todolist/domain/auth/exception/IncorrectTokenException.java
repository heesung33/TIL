package com.example.todolist.domain.auth.exception;

import com.example.todolist.global.error.ErrorCode;
import com.example.todolist.global.error.exception.SnsException;

public class IncorrectTokenException extends SnsException {
    public static SnsException EXCEPTION =
            new IncorrectTokenException();

    private IncorrectTokenException() {
        super(ErrorCode.INCORRECT_TOKEN);
    }
}
