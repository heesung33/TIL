package com.example.crud.entity.comment;

import com.example.crud.entity.BaseTimeEntity.BaseTimeEntity;
import com.example.crud.entity.post.Post;
import lombok.*;

import javax.persistence.*;



@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String  comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment update(String userId, String comment) {
        this.userId = userId;
        this.comment = comment;
        return this;
    }

}
