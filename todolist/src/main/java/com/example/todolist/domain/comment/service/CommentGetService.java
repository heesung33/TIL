package com.example.todolist.domain.comment.service;


import com.example.todolist.domain.comment.api.dto.response.CommentRecordResponse;

import com.example.todolist.domain.comment.domain.repository.CommentRepository;
import com.example.todolist.domain.post.domain.Post;
import com.example.todolist.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;



@RequiredArgsConstructor
@Service
public class CommentGetService {

    private final CommentRepository commentRepository;
    private final PostRepository toDoListRepository;


    @Transactional
    public List<CommentRecordResponse> execute(Long id) {
        Post toDoList = toDoListRepository.findById(id).orElseThrow(RuntimeException::new);
        return commentRepository.findAllByToDoListId(id)
                .stream()
                .map(comment -> {
                    CommentRecordResponse commentRecordResponse = new CommentRecordResponse(toDoList, comment.getContent());
                    return commentRecordResponse;
                })
                .collect(Collectors.toList());
    }


}
