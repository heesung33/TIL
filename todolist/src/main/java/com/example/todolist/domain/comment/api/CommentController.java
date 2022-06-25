package com.example.todolist.domain.comment.api;

import com.example.todolist.domain.comment.api.dto.request.CommentRecordRequset;

import com.example.todolist.domain.comment.api.dto.response.CommentRecordResponse;
import com.example.todolist.domain.comment.service.CommentCreateService;
import com.example.todolist.domain.comment.service.CommentDeleteService;
import com.example.todolist.domain.comment.service.CommentGetService;
import com.example.todolist.domain.comment.service.CommentUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentCreateService commentCreateService;
    private final CommentUpdateService commentUpdateService;
    private final CommentGetService commentGetService;
    private final CommentDeleteService commentDeleteService;

    @PostMapping("/create/{id}")
    public void create(@RequestBody CommentRecordRequset commentRecord,
                       @PathVariable Long id) {
        commentCreateService.execute(commentRecord, id);
    }

    @PatchMapping("/update/{id}")
    public void update(@RequestBody CommentRecordRequset commentRecord,
                       @PathVariable Long id) {
        commentUpdateService.execute(commentRecord, id);
    }

    @GetMapping("/get/{id}")
    public List<CommentRecordResponse> get(@PathVariable Long id) {
        return commentGetService.execute(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        commentDeleteService.execute(id);
    }

}
