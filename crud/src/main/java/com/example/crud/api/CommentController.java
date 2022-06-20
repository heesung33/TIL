package com.example.crud.api;

import com.example.crud.api.dto.request.CommentRequest;
import com.example.crud.api.dto.response.CommentResponse;
import com.example.crud.service.comment.CommentWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentWriteService commentService;

    @PostMapping("/comment")
    public CommentResponse writeComment(@RequestBody CommentRequest commentRequest) {
        return commentService.execute(commentRequest);
    }



}
