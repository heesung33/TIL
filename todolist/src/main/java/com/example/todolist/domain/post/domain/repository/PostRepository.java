package com.example.todolist.domain.post.domain.repository;

import com.example.todolist.domain.post.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
