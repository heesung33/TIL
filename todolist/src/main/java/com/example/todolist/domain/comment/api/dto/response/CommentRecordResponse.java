package com.example.todolist.domain.comment.api.dto.response;


import com.example.todolist.domain.todolist.domain.ToDoList;

import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;



public record CommentRecordResponse(
        @NotBlank ToDoList toDoList,
        @NotBlank String content
) {

}
