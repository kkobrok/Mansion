package com.example.Mansion.controller;


import com.example.Mansion.entity.CommentEntity;
import com.example.Mansion.entity.PostEntity;
import com.example.Mansion.entity.UserEntity;
import com.example.Mansion.repository.CommentRepository;
import com.example.Mansion.repository.PostRepository;
import com.example.Mansion.repository.UserRepository;
import com.example.Mansion.services.PostService;
import com.example.Mansion.services.SecUserDetailsService;
import com.example.Mansion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController()
@RequestMapping("/api/user")
public class UserController {
    UserRepository userRepository;
    UserService userService;
    PostRepository postRepository;
    CommentRepository commentRepository;
    PostService postService;

    SecUserDetailsService secUserDetailsService;

    @Autowired
    public UserController(UserRepository userRepository,
                          UserService userService, PostRepository postRepository,
                          CommentRepository commentRepository, PostService postService,
                          SecUserDetailsService secUserDetailsService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.secUserDetailsService = secUserDetailsService;
    }

    @GetMapping("/{userName}/post")
    public List<PostEntity> getUserPostList(@RequestParam String userName) {
        return postRepository.findAllByAuthor(userName).orElseThrow(NoSuchElementException::new);
    }
    @GetMapping("/{userName}/comment")
    public List<CommentEntity> getUserCommentList(@RequestParam String userName) {
        return commentRepository.findAllByCommentUser(userName).orElseThrow(NoSuchElementException::new);
    }

    @GetMapping
    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }


    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
//        secUserDetailsService.loadUserByUsername(userEntity.getLogin());
        return userRepository.save(userEntity);
    }

}
