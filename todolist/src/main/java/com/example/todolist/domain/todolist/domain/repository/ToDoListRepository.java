package com.example.todolist.domain.todolist.domain.todolist.repository;

import com.example.todolist.domain.todolist.domain.todolist.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
