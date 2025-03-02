package com.example.SecurityApp.controllers;

import com.example.SecurityApp.dto.PostDTO;
import com.example.SecurityApp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    private List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    private PostDTO createPosts(@RequestBody PostDTO postDTO) {
        return postService.createPosts(postDTO);
    }

    @GetMapping("/{id}")
    private PostDTO getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
}
