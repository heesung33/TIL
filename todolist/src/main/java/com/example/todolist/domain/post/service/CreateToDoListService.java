package com.example.todolist.domain.post.service;


import com.example.todolist.domain.post.api.dto.request.PostRecord;
import com.example.todolist.domain.post.domain.Post;

import com.example.todolist.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateToDoListService {

    private final PostRepository toDoListRepository;

    @Transactional
    public void execute(PostRecord record){
        toDoListRepository.save(
                Post.builder()
                        .title(record.title())
                        .content(record.content())
                .build());
    }


}
