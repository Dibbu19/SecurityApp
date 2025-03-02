package com.example.SecurityApp.services;

import com.example.SecurityApp.dto.PostDTO;

import java.util.List;

public interface PostServiceInterface {

    List<PostDTO> getAllPosts();

    PostDTO createPosts(PostDTO postDTO);

    PostDTO getPostById(Long id);
}
