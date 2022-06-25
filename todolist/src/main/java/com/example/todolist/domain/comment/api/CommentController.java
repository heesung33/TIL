package com.example.todolist.domain.comment.api;

import com.example.todolist.domain.comment.api.dto.request.CommentRecord;
import com.example.todolist.domain.comment.api.dto.response.CommentResponse;
import com.example.todolist.domain.comment.domain.Comment;
import com.example.todolist.domain.comment.service.CommentCreateService;
import com.example.todolist.domain.comment.service.CommentDeleteService;
import com.example.todolist.domain.comment.service.CommentGetService;
import com.example.todolist.domain.comment.service.CommentUpdateService;
import com.example.todolist.domain.todolist.domain.ToDoList;
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
    public void create(@RequestBody CommentRecord commentRecord,
                       @PathVariable Long id) {
        commentCreateService.execute(commentRecord, id);
    }

    @PatchMapping("/update/{id}")
    public void update(@RequestBody CommentRecord commentRecord,
                       @PathVariable Long id) {
        commentUpdateService.execute(commentRecord, id);
    }

    @GetMapping("/get/{id}")
    public List<CommentResponse> get(@PathVariable Long id) {
        return commentGetService.execute(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        commentDeleteService.execute(id);
    }

}
