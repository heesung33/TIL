package com.example.crud.entity.comment;

import com.example.crud.entity.BaseTimeEntity.BaseTimeEntity;
import com.example.crud.entity.post.Post;
import lombok.*;

import javax.persistence.*;



@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Comment( String comment, Post post) {
        this.comment = comment;
        this.post = post;
    }

    public Comment update(String comment) {
        this.comment = comment;
        return this;
    }

}
