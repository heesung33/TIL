package com.example.todolist.domain.comment.service;

import com.example.todolist.domain.comment.api.dto.request.CommentRecord;
import com.example.todolist.domain.comment.domain.Comment;
import com.example.todolist.domain.comment.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentUpdateService {

    private final CommentRepository commentRepository;

    @Transactional
    public void execute(CommentRecord commentRecord, Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(RuntimeException::new);

        comment.update(commentRecord.content());
    }

}
