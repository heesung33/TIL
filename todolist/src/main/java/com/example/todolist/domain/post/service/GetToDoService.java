package com.example.todolist.domain.post.service;


import com.example.todolist.domain.post.api.dto.response.PostResponse;
import com.example.todolist.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GetToDoService {

    private final PostRepository toDoListRepository;

    @Transactional
    public PostResponse execute(Long id) {
        return toDoListRepository.findById(id)
                .map(toDoList -> PostResponse.builder()
                        .title(toDoList.getTitle())
                        .content(toDoList.getContent())
                        .build()
                ).orElseThrow(RuntimeException::new);
        }
}

