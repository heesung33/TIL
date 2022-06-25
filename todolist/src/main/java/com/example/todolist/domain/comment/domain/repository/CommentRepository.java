package com.example.todolist.domain.comment.domain.repository;

import com.example.todolist.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByToDoListId(Long id);

}
