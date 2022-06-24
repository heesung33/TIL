package com.example.todolist.domain.todolist.service.todolist;

import com.example.todolist.domain.todolist.api.dto.request.ToDoRecord;
import com.example.todolist.domain.todolist.domain.ToDoList;
import com.example.todolist.domain.todolist.domain.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateToDoListService {

    private final ToDoListRepository toDoListRepository;

    @Transactional
    public void execute(ToDoRecord record, Long id) {
        ToDoList toDoList = toDoListRepository.findById(id).orElseThrow(RuntimeException::new);

        toDoList.update(record.title(), record.content());
    }
}
