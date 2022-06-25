package com.example.todolist.domain.comment.api;

import com.example.todolist.domain.comment.api.dto.request.CommentRecord;
import com.example.todolist.domain.comment.service.CommentCreateService;
import com.example.todolist.domain.comment.service.CommentUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentCreateService commentCreateService;
    private final CommentUpdateService commentUpdateService;

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

}
