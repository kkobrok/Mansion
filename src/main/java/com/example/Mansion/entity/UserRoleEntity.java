package com.example.Mansion.entity;


import lombok.Data;

import javax.persistence.*;

@Data
public class UserRoleEntity {
    @Id
    private String role;
    private UserEntity user;
}
