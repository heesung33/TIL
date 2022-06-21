package com.example.crud.api;


import com.example.crud.api.dto.request.PostRequest;
import com.example.crud.api.dto.response.PostResponse;
import com.example.crud.entity.post.Post;
import com.example.crud.service.post.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostCreateService postService;
    private final PostDeleteService postDeleteService;
    private final PostGetAllService postGetAllService;
    private final PostGetService postGetService;
    private final PostUpdateService postUpdateService;

    @PostMapping("/create")
    public void create(@RequestBody PostRequest postRequest) {
      postService.execute(postRequest);
    }

    @GetMapping("/get")
    public List<Post> getAll() {
        return postGetAllService.execute();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        postDeleteService.execute(id);
    }

    @GetMapping("/get/{id}")
    public PostResponse get(@PathVariable Long id) {
        return postGetService.execute(id);
    }

    @PatchMapping("/update/{id}")
    public void update(@RequestBody PostRequest request, @PathVariable Long id) {
        postUpdateService.execute(request, id);
    }
}
