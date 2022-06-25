package com.example.todolist.domain.comment.service;


import com.example.todolist.domain.comment.api.dto.response.CommentResponse;
import com.example.todolist.domain.comment.domain.repository.CommentRepository;
import com.example.todolist.domain.todolist.domain.ToDoList;
import com.example.todolist.domain.todolist.domain.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;



@RequiredArgsConstructor
@Service
public class CommentGetService {

    private final CommentRepository commentRepository;
    private final ToDoListRepository toDoListRepository;

    @Transactional
    public List<CommentResponse> execute(Long id) {
        ToDoList toDoList = toDoListRepository.findById(id).orElseThrow(RuntimeException::new);
        return commentRepository.findAllByToDoListId(id)
                .stream()
                .map(comment -> {
                    CommentResponse commentResponse = CommentResponse.builder()
                            .toDoList(toDoList)
                            .content(comment.getContent())
                            .build();
                    return commentResponse;
                })
                .collect(Collectors.toList());
    }


}
