package com.example.todolist.domain.comment.service;


import com.example.todolist.domain.auth.domain.User;
import com.example.todolist.domain.comment.api.dto.request.CommentRecordRequset;
import com.example.todolist.domain.comment.domain.Comment;
import com.example.todolist.domain.comment.domain.repository.CommentRepository;
import com.example.todolist.domain.post.domain.Post;
import com.example.todolist.domain.post.domain.repository.PostRepository;
import com.example.todolist.global.facade.CurrentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class CommentCreateService {

    private final CommentRepository commentRepository;
    private final PostRepository toDoListRepository;
    private final CurrentFacade currentFacade;


    @Transactional
    public void execute(CommentRecordRequset commentRecord, Long id) {
        Post toDoList = toDoListRepository.findById(id).orElseThrow(RuntimeException::new);

        User user = currentFacade.getCurrentUser();

        commentRepository.save(
                Comment.builder()
                        .user(user)
                        .toDoList(toDoList)
                        .content(commentRecord.content())
                        .build()
        );
    }
}
