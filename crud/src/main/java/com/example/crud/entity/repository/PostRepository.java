package com.example.crud.entity.repository;

import com.example.crud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> deleteByTitle(String title);
}
