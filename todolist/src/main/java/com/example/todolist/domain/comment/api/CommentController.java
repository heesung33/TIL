package com.example.todolist.domain.todolist.api;

import com.example.todolist.domain.todolist.api.dto.request.CommentRecord;
import com.example.todolist.domain.todolist.service.comment.CommentCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentCreateService commentCreateService;

    @PostMapping("/create/{id}")
    public void create(@RequestBody CommentRecord commentRecord,
                       @PathVariable Long id) {
        commentCreateService.execute(commentRecord, id);
    }

}
