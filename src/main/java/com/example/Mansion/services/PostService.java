package com.example.Mansion.services;


import com.example.Mansion.dao.PostRequest;
import com.example.Mansion.dao.PostResponse;
import com.example.Mansion.entity.CommentEntity;
import com.example.Mansion.entity.PostEntity;
import com.example.Mansion.entity.UserEntity;
import com.example.Mansion.repository.CommentRepository;
import com.example.Mansion.repository.PostRepository;
import com.example.Mansion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PostService {
    PostRepository postRepository;
    UserRepository userRepository;
    CommentRepository commentRepository;


    @Autowired
    public PostService(PostRepository postRepository,
                       UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public PostEntity savePostFromUser(PostRequest postRequest, String userId) {
        PostEntity postEntity = new PostEntity();
        postEntity.setAuthor(postRequest.getAuthor());
        postEntity.setHeader(postRequest.getHeader());
        postEntity.setPicture(postRequest.getPicture());
        postEntity.setGrade(0);
        UserEntity userEntity = userRepository.findFirstByLogin(userId).
                orElseThrow(NoSuchElementException::new);
        postEntity.setUserEntity(userEntity);
        postEntity.setTagList(postRequest.getTagList());
        postEntity.setId((userEntity.getLogin() + "p" + System.currentTimeMillis()));//not sure if it good
        return postRepository.save(postEntity);
    }

    public List<PostResponse> getAllPostResponse(){
        return postRepository.findAll().stream()
        .map(PostResponse::new)
        .collect(Collectors.toList());
    }

    public PostEntity addCommentToPost(CommentEntity comment, String userId, String memId){
        userRepository.findFirstByLogin(userId).
                orElseThrow(NoSuchElementException::new);// do i really need this ?
        comment.setCommentUser(userId);
        PostEntity postEntity = postRepository.findById(memId).
                orElseThrow(NoSuchElementException::new);
        postEntity.getCommentEntityList().add(comment);
        return postRepository.save(postEntity);
    }


}