package com.example.todolist.domain.post.service;

import com.example.todolist.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteToDoListService {

    private final PostRepository toDoListRepository;

    @Transactional
    public void  execute(Long id) {
        toDoListRepository.deleteById(id);
    }
}
