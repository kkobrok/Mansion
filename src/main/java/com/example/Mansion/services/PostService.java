package com.example.Mansion.services;


import com.example.Mansion.dao.PostRequest;
import com.example.Mansion.entity.PostEntity;
import com.example.Mansion.entity.UserEntity;
import com.example.Mansion.repository.PostRepository;
import com.example.Mansion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PostService {
    PostRepository postRepository;
    UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostEntity savePostFromUser(PostRequest postRequest, String userId) {
        PostEntity postEntity = new PostEntity();
        postEntity.setAuthor(postRequest.getAuthor());
        postEntity.setHeader(postRequest.getHeader());
        postEntity.setPicture(postRequest.getPicture());
        postEntity.setGrade(0);
        postEntity.setUserEntity(userRepository.findById(userId).
                orElseThrow(NoSuchElementException::new));
        return postRepository.save(postEntity);

    }
}
