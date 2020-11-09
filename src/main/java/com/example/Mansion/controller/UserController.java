package com.example.Mansion.controller;


import com.example.Mansion.entity.UserEntity;
import com.example.Mansion.repository.UserRepository;
import com.example.Mansion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/user")
public class UserController {
    UserRepository userRepository;
    UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getUserList(){
        return userRepository.findAll();
    }


    @PostMapping
    public UserEntity addUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

}
