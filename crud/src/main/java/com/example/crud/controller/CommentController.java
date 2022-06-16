package com.example.crud.controller;

import com.example.crud.controller.dto.request.CommentRequest;
import com.example.crud.controller.dto.response.CommentResponse;
import com.example.crud.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment")
    public CommentResponse writeComment(@RequestBody CommentRequest commentRequest) {
        return commentService.writeComment(commentRequest);
    }



}
