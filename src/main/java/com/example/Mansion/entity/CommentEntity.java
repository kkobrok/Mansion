package com.example.Mansion.entity;

import lombok.Data;
import javax.persistence.Id;


@Data
public class CommentEntity {

    @Id
    String id;
    String commentContent;
    String commentUser;
    int grade;

}
