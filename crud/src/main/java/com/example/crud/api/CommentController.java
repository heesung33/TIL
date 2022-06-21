package com.example.crud.api;

import com.example.crud.api.dto.request.CommentRequest;
import com.example.crud.api.dto.response.CommentResponse;
import com.example.crud.entity.comment.Comment;
import com.example.crud.service.comment.CommentDeleteService;
import com.example.crud.service.comment.CommentGetService;
import com.example.crud.service.comment.CommentUpdateService;
import com.example.crud.service.comment.CommentWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentWriteService commentWriteServiceService;
    private final CommentDeleteService commentDeleteService;
    private final CommentUpdateService commentUpdateService;
    private final CommentGetService commentGetService;

    @PostMapping("/create")
    public void createComment(@RequestBody CommentRequest commentRequest) {
        commentWriteServiceService.execute(commentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable long id) {
        commentDeleteService.execute(id);
    }

    @PatchMapping("/update/{id}")
    public void updateComment(@RequestBody CommentRequest commentRequest, @PathVariable long id) {
        commentUpdateService.execute(commentRequest, id);
    }


    @GetMapping("/get")
    public List<Comment> get(){
        return commentGetService.execute();
    }


}
