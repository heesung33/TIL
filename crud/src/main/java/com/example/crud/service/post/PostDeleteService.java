package com.example.crud.service.post;

import com.example.crud.entity.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostDeleteService {

    private final PostRepository postRepository;

    @Transactional
    public void execute(Long id) {
        postRepository.deleteById(id);
    }
}
