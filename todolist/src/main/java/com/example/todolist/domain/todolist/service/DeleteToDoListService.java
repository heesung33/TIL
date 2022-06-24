package com.example.todolist.domain.todolist.service.todolist;

import com.example.todolist.domain.todolist.domain.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteToDoListService {

    private final ToDoListRepository toDoListRepository;

    @Transactional
    public void  execute(Long id) {
        toDoListRepository.deleteById(id);
    }
}
