package com.example.crud.service.comment;


import com.example.crud.controller.dto.request.CommentRequest;
import com.example.crud.controller.dto.response.CommentResponse;
import com.example.crud.entity.comment.Comment;
import com.example.crud.entity.comment.CommentRepository;
import com.example.crud.entity.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponse writeComment(CommentRequest commentRequest){
        return postRepository.findById(commentRequest.getBoardId())
                .map(post -> {
                    Comment comment = Comment.builder()
                            .userId(commentRequest.getUserId())
                            .comment(commentRequest.getComment())
                            .post(post)
                            .build();
                    commentRepository.save(comment);
                    return new CommentResponse(comment);
                })
                .orElseThrow(RuntimeException::new);
    }
}
