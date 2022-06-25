package com.example.todolist.domain.comment.api.dto.response;


import com.example.todolist.domain.todolist.domain.ToDoList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


public record CommentRecord(
        @NotBlank ToDoList toDoList,
        @NotBlank String content
) {

}
