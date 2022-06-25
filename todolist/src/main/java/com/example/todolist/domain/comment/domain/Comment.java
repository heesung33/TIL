package com.example.todolist.domain.comment.domain;


import com.example.todolist.domain.todolist.domain.ToDoList;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private ToDoList toDoList;

    @Builder
    public Comment(String content, ToDoList toDoList) {
        this.content = content;
        this.toDoList = toDoList;
    }

    public void update(String content) {
        this.content = content;
    }

}
