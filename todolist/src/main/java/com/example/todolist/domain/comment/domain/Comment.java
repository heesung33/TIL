package com.example.todolist.domain.comment.domain;


import com.example.todolist.domain.auth.domain.User;
import com.example.todolist.global.entity.BaseTimeEntity;
import com.example.todolist.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post toDoList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Comment(String content, Post toDoList, User user) {
        this.content = content;
        this.toDoList = toDoList;
        this.user = user;
    }

    public void update(String content) {
        this.content = content;
    }

}
