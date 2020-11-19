package com.example.Mansion.dao;


import com.example.Mansion.entity.PostEntity;
import com.example.Mansion.entity.UserEntity;
import lombok.Data;

@Data
public class PostResponse {
    public PostResponse(PostEntity postEntity) {
        this.header = postEntity.getHeader();
        this.author = postEntity.getAuthor();
        this.picture = postEntity.getPicture();
        this.grade = postEntity.getGrade();
        this.userName = postEntity.getUserEntity().getLogin();
    }

    String header;
    String author;
    String picture;
    int grade;
    String userName;
}
