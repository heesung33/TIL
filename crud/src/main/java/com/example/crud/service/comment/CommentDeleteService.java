package com.example.crud.service.comment;

import com.example.crud.entity.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentDeleteService {

    private final CommentRepository commentRepository;


    @Transactional
    public void execute(long id){
        commentRepository.deleteById(id);
    }


}
