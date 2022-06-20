package com.example.crud.service.post;

import com.example.crud.api.dto.request.PostRequest;
import com.example.crud.entity.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostUpdateService {

    private final PostRepository postRepository;


    @Transactional
    public void execute(PostRequest request, Long id) {
        postRepository.findById(id)
                .map(newPost -> newPost.update(
                        request.getTitle(),
                        request.getContent()
                ))
                .orElseThrow(RuntimeException::new);
    }
}
