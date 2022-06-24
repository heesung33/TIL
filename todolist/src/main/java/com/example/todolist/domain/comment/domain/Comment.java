package com.example.todolist.domain.todolist.domain.comment;


import com.example.todolist.domain.todolist.domain.todolist.ToDoList;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private ToDoList toDoList;

    @Builder
    public Comment(String content, ToDoList toDoList) {
        this.content = content;
        this.toDoList = toDoList;
    }

}
