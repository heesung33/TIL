package com.example.crud.entity.post;


import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @Column(length = 1200)
    private String title;

    private String content;


    public Post update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
}
