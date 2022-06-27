package com.example.todolist.domain.post.domain.repository;

import com.example.todolist.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
