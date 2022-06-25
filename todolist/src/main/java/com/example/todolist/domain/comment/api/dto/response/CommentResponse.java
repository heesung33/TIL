package com.example.todolist.domain.comment.api.dto.response;


import com.example.todolist.domain.todolist.domain.ToDoList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommentResponse {
    private final ToDoList toDoList;
    private final String content;
}
