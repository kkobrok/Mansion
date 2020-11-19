package com.example.Mansion.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Data
public class PostEntity {
    @Id
    String id;
    String header;
    String author;
    String picture;
    int grade;
    UserEntity userEntity;
    List <CommentEntity> commentEntityList = new ArrayList<>();
    List <CommentEntity> tagList = new ArrayList<>();

}
