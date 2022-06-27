package com.example.todolist.domain.post.service;

import com.example.todolist.domain.post.api.dto.request.PostRecord;
import com.example.todolist.domain.post.domain.Post;
import com.example.todolist.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateToDoListService {

    private final PostRepository toDoListRepository;

    @Transactional
    public void execute(PostRecord record, Long id) {
        Post toDoList = toDoListRepository.findById(id).orElseThrow(RuntimeException::new);

        toDoList.update(record.title(), record.content());
    }
}
