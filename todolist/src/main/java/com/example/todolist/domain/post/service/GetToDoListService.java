package com.example.todolist.domain.post.service;

import com.example.todolist.domain.post.domain.Post;

import com.example.todolist.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@RequiredArgsConstructor
@Service
public class GetToDoListService {

    private final PostRepository toDoListRepository;

    @Transactional
    public List<Post> execute() {
        return toDoListRepository.findAll();
    }


}
