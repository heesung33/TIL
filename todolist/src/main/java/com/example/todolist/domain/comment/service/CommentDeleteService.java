package com.example.todolist.domain.comment.service;


import com.example.todolist.domain.comment.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentDeleteService {

    private final CommentRepository commentRepository;

    @Transactional
    public void execute(Long id) {
        commentRepository.deleteById(id);
    }
}
