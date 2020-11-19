package com.example.Mansion.dao;

import com.example.Mansion.entity.CommentEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostRequest {
    String author;
    String picture;
    int grade;
    String header;
    List<CommentEntity> tagList = new ArrayList<>();

}
