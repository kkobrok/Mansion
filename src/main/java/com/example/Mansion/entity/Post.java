package com.example.Mansion.entity;


import lombok.Builder;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Post {

    @Id
    Long id;
    String author;
    String picture;
    int grade;

}