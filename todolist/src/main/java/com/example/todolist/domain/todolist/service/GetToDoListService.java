package com.example.todolist.domain.todolist.service;

import com.example.todolist.domain.todolist.domain.ToDoList;
import com.example.todolist.domain.todolist.domain.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@RequiredArgsConstructor
@Service
public class GetToDoListService {

    private final ToDoListRepository toDoListRepository;

    @Transactional
    public List<ToDoList> execute() {
        return toDoListRepository.findAll();
    }


}
