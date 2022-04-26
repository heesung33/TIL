package com.example.crud.service;


import com.example.crud.controller.dto.PostRequest;
import com.example.crud.controller.dto.PostResponse;
import com.example.crud.entity.Post;
import com.example.crud.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public String create(PostRequest postRequest) {
        postRepository.save(Post.builder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .build());
        return "success!";
    }

    @Transactional
    public String delete(String title) {
        postRepository.deleteByTitle(title);
        return "success";
    }

    public List<Post> read() {
        return postRepository.findAll();
    }

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


    public void updateEx(PostRequest request, Long id) {
        postRepository.deleteById(id);
        postRepository.save(Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());
    }

}
