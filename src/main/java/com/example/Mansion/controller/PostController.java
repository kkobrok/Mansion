package com.example.Mansion.controller;


import com.example.Mansion.dao.PostRequest;
import com.example.Mansion.dao.PostResponse;
import com.example.Mansion.entity.CommentEntity;
import com.example.Mansion.entity.PostEntity;
import com.example.Mansion.repository.PostRepository;
import com.example.Mansion.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

    @PostMapping("/{userId}/post")
    public PostEntity addPost(@RequestBody PostRequest postRequest, @RequestParam String userId) {
        return postService.savePostFromUser(postRequest, userId);
    }

    @GetMapping
    public List<PostResponse> getAllPost() {
        return postService.getAllPostResponse();
    }

    @GetMapping("/{memId}")
    public PostEntity getPost(@RequestParam String memId) {
        return postRepository.findFirstById(memId).
                orElseThrow(NoSuchElementException::new);
    }


    @PatchMapping("/{memId}")
    public PostEntity addCommentToPost(@RequestBody CommentEntity comment,
                                       @RequestAttribute String userId,
                                       @RequestParam String memId) {
        return postService.addCommentToPost(comment, userId, memId);
    }
}
