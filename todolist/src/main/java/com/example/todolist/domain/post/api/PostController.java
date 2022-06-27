package com.example.todolist.domain.post.api;

import com.example.todolist.domain.post.api.dto.request.ToDoRecord;
import com.example.todolist.domain.post.api.dto.response.ToDoResponse;
import com.example.todolist.domain.post.domain.ToDoList;
import com.example.todolist.domain.post.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class ToDoListController {

    private final CreateToDoListService createToDoListService;
    private final GetToDoListService getToDoListService;
    private final DeleteToDoListService deleteToDoListService;
    private final UpdateToDoListService updateToDoListService;
    private final GetToDoService getToDoService;

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
    public void patchToDoList(@RequestBody ToDoRecord record, @PathVariable Long id) {
        updateToDoListService.execute(record, id);
    }

    @GetMapping("/getall/{id}")
    public ToDoResponse getAllToDo(@PathVariable Long id) {
        return getToDoService.execute(id);
    }
}
