package com.example.todolist.domain.comment.api.dto.response;


import com.example.todolist.domain.post.domain.Post;


import javax.validation.constraints.NotBlank;



public record CommentRecordResponse(
        @NotBlank Post toDoList,
        @NotBlank String content
) {

}
