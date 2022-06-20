package com.example.crud.service.post;


import com.example.crud.api.dto.request.PostRequest;
import com.example.crud.entity.post.Post;
import com.example.crud.entity.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@RequiredArgsConstructor
@Service
public class PostCreateService {

    private final PostRepository postRepository;

    @Transactional
    public void execute(PostRequest postRequest) {
        postRepository.save(Post.builder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .build());
    }


}
