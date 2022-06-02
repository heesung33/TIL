package com.example.crud.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1200)
    private String title;

    private String content;


    public Post update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
}
