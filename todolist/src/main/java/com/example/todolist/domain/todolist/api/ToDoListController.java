package com.example.todolist.domain.todolist.api;

import com.example.todolist.domain.todolist.api.dto.request.ToDoRecord;
import com.example.todolist.domain.todolist.domain.ToDoList;
import com.example.todolist.domain.todolist.service.CreateToDoListService;
import com.example.todolist.domain.todolist.service.DeleteToDoListService;
import com.example.todolist.domain.todolist.service.GetToDoListService;
import com.example.todolist.domain.todolist.service.UpdateToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ToDoListController {

    private final CreateToDoListService createToDoListService;
    private final GetToDoListService getToDoListService;
    private final DeleteToDoListService deleteToDoListService;
    private final UpdateToDoListService updateToDoListService;

    @PostMapping("/create")
    public void createToDoList(@RequestBody @Valid ToDoRecord record) {
            createToDoListService.execute(record);
    }

    @GetMapping("/list")
    public List<ToDoList> getToDoList(){
        return getToDoListService.execute();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteToDoList(@PathVariable Long id) {
        deleteToDoListService.execute(id);
    }

    @PatchMapping("/update/{id}")
    public void PatchToDoList(@RequestBody ToDoRecord record, @PathVariable Long id) {
        updateToDoListService.execute(record, id);
    }
}
