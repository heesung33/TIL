package com.example.crud.controller;


import com.example.crud.controller.dto.request.PostRequest;
import com.example.crud.controller.dto.response.PostResponse;
import com.example.crud.entity.post.Post;
import com.example.crud.entity.post.PostRepository;
import com.example.crud.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public void create(@RequestBody PostRequest postRequest) {
      postService.create(postRequest);
    }

    @GetMapping("/get")
    public List<Post> read() {
        return postService.read();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }

    @GetMapping("/{id}")
    public PostResponse get(@PathVariable Long id) {
        return postService.get(id);
    }

    @PatchMapping("{id}")
    public void update(@RequestBody PostRequest request, @PathVariable Long id) {
        postService.update(request, id);
    }

    @PatchMapping("/new/{id}")
    public void updateEx(@RequestBody PostRequest request, @PathVariable Long id) {
        postService.updateEx(request, id);
    }
}
