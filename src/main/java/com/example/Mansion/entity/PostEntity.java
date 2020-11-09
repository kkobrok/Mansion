package com.example.Mansion.entity;



import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
public class PostEntity {
    @Id
    Long id;
    String header;
    String author;
    String picture;
    int grade;
    UserEntity userEntity;

}
