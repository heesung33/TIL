package com.example.crud.service.comment;


import com.example.crud.api.dto.request.CommentRequest;
import com.example.crud.entity.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentUpdateService {

    private final CommentRepository commentRepository;


    @Transactional
    public void execute(CommentRequest commentRequest, long id) {
        commentRepository.findById(id)
                .map(newComment -> newComment.update(
                        commentRequest.getComment(),
                        commentRequest.getUserId()

                ))
                .orElseThrow(RuntimeException::new);
    }
}
