package com.example.crud.service.post;


import com.example.crud.controller.dto.request.PostRequest;
import com.example.crud.controller.dto.response.PostResponse;
import com.example.crud.entity.post.Post;
import com.example.crud.entity.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void create(PostRequest postRequest) {
        postRepository.save(Post.builder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .build());
    }

    @Transactional
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public List<Post> read() {
        return postRepository.findAll();
    }

    @Transactional
    public PostResponse get(Long id) {
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

    @Transactional
    public void update(PostRequest request, Long id) {
        postRepository.findById(id)
                .map(newPost -> newPost.update(
                        request.getTitle(),
                        request.getContent()
                ))
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void updateEx(PostRequest request, Long id) {
        postRepository.deleteById(id);
        postRepository.save(Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());
    }

}
