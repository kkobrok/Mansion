package com.example.Mansion.repository;

import com.example.Mansion.entity.CommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CommentRepository extends MongoRepository<CommentEntity,String> {
    Optional<List<CommentEntity>> findAllByCommentUser(String commenterLogin);
}
