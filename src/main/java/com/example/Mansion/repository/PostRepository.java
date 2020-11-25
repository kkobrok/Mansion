package com.example.Mansion.repository;


import com.example.Mansion.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends MongoRepository<PostEntity,String> {
    Optional<List<PostEntity>> findAllByAuthor(String author);
    Optional<PostEntity> findFirstById (String Id);
}
