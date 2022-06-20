package com.example.crud.service.post;

import com.example.crud.entity.post.Post;
import com.example.crud.entity.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostReadService {

    private final PostRepository postRepository;

    @Transactional
    public List<Post> execute() {
        return postRepository.findAll();
    }
}
