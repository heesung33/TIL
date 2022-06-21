package com.example.crud.api.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequest {
    private long boardId;
    private String userId;
    private String comment;

}
