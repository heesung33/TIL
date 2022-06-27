package com.example.todolist.domain.todolist.service;


import com.example.todolist.domain.todolist.api.dto.response.ToDoResponse;
import com.example.todolist.domain.todolist.domain.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GetToDoService {

    private final ToDoListRepository toDoListRepository;

    @Transactional
    public ToDoResponse execute(Long id) {
        return toDoListRepository.findById(id)
                .map(toDoList -> ToDoResponse.builder()
                        .title(toDoList.getTitle())
                        .content(toDoList.getContent())
                        .build()
                ).orElseThrow(RuntimeException::new);
        }
}

