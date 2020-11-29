package com.example.Mansion.config;

import com.example.Mansion.entity.UserEntity;
import com.example.Mansion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestDataBean {

    private UserRepository userRepository;
//    private PasswordEncoder encoder;

    @Autowired
    public TestDataBean(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @PostConstruct
    public void init(){
        userRepository.save(testUserForTry());
    }
    private UserEntity testUserForTry(){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("blank@blank");
        userEntity.setLogin("blank");
        userEntity.setPassword(("blank"));
        userEntity.setRole("API_USER");
        return userEntity;
    }

}
