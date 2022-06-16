package com.example.crud.controller.dto.response;


import com.example.crud.entity.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponse {
    private final Comment comment;
}
