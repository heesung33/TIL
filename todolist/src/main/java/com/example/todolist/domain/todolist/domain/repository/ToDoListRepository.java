package com.example.todolist.domain.todolist.domain.repository;

import com.example.todolist.domain.todolist.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
