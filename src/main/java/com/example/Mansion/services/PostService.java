package com.example.Mansion.services;


import com.example.Mansion.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
     PostRepository postRepository;
     @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
