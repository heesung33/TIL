package com.example.crud.service.post;

import com.example.crud.api.dto.response.PostResponse;
import com.example.crud.entity.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostGetService {
    private final PostRepository postRepository;

    @Transactional
    public PostResponse execute(Long id) {
        return postRepository.findById(id)
                .map(post -> {
                    PostResponse response = PostResponse.builder()
                            .title(post.getTitle())
                            .content(post.getContent())
                            .build();
                    return response;
                })
                .orElseThrow(RuntimeException::new);
    }
}
