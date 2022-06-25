
package com.example.crud.service.comment;


import com.example.crud.entity.comment.Comment;
import com.example.crud.entity.comment.CommentRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CommentGetService {

    private final CommentRepository commentRepository;


    @Transactional
    public List<Comment> execute() {
        return commentRepository.findAll();
    }

}

