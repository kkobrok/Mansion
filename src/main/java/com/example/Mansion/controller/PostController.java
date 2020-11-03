package com.example.Mansion.controller;


import com.example.Mansion.entity.Post;
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
    public Post addPost(@RequestBody Post post){
        return postRepository.save(post);
    }
    @GetMapping
    public List<Post> getPost(){
        return postRepository.findAll();
    }

}
