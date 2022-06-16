package com.example.todolist.domain.todolist.service;


import com.example.todolist.domain.todolist.api.dto.request.ToDoRecord;
import com.example.todolist.domain.todolist.domain.ToDoList;
import com.example.todolist.domain.todolist.domain.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateToDoListService {

    private final ToDoListRepository toDoListRepository;

    @Transactional
    public void execute(ToDoRecord record){
        toDoListRepository.save(
                ToDoList.builder()
                        .title(record.title())
                        .content(record.content())
                .build());
    }


}
