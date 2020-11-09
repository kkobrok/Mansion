package com.example.Mansion.controller;


import com.example.Mansion.dao.PostRequest;
import com.example.Mansion.entity.PostEntity;
import com.example.Mansion.entity.UserEntity;
import com.example.Mansion.repository.PostRepository;
import com.example.Mansion.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/post")
public class PostController {
    PostRepository postRepository;
    PostService postService;

    @Autowired
    public PostController(PostRepository postRepository, PostService postService) {
        this.postRepository = postRepository;
        this.postService = postService;
    }

    @PostMapping
    public PostEntity addPost(@RequestBody PostRequest postRequest, @RequestParam String userId){
        return postService.savePostFromUser(postRequest,userId);
    }
    @GetMapping
    public List<PostEntity> getPost(){
        return postRepository.findAll();
    }

}
