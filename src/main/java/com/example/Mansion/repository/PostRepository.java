package com.example.Mansion.repository;


import com.example.Mansion.entity.Post;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
