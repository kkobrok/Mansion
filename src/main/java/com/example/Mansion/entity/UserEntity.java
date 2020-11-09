package com.example.Mansion.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//@Entity
@Data
public class UserEntity {

    @Id
    String login;
    String email;
    String password;
    String role;

}
