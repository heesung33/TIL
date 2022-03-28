package com.example.crud.controller;


import com.example.crud.controller.dto.PostRequest;
import com.example.crud.controller.dto.PostResponse;
import com.example.crud.entity.Post;
import com.example.crud.entity.repository.PostRepository;
import com.example.crud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/post")
    public String create(@RequestBody PostRequest postRequest) {
        return postService.create(postRequest);
    }

    @GetMapping("/get")
    public List<Post> read() {
        return postService.read();
    }

    @DeleteMapping("/delete/{title}")
    public String delete(@PathVariable String title) {
        return postService.delete(title);
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
