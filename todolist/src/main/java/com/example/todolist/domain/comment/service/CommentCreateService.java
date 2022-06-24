package com.example.todolist.domain.todolist.service.comment;


import com.example.todolist.domain.comment.api.dto.request.CommentRecord;
import com.example.todolist.domain.comment.domain.Comment;
import com.example.todolist.domain.comment.domain.repository.CommentRepository;
import com.example.todolist.domain.todolist.domain.ToDoList;
import com.example.todolist.domain.todolist.domain.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class CommentCreateService {

    private final CommentRepository commentRepository;
    private final ToDoListRepository toDoListRepository;


    @Transactional
    public void execute(CommentRecord commentRecord, Long id) {
        ToDoList toDoList = toDoListRepository.findById(id).orElseThrow(RuntimeException::new);

        commentRepository.save(
                Comment.builder()
                        .toDoList(toDoList)
                        .content(commentRecord.content())
                        .build()
        );
    }
}
