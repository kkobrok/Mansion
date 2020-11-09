package com.example.Mansion.dao;

import lombok.Data;

@Data
public class PostRequest {
    String author;
    String picture;
    int grade;
    String header;
}
