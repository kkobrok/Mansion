package com.example.Mansion.services;

import com.example.Mansion.entity.SecUserDetails;
import com.example.Mansion.entity.UserEntity;
import com.example.Mansion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class SecUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private PasswordEncoder encoder;


    @Autowired
    public SecUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
        encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        userRepository.save(testUserForTry());
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Here add user data layer fetching from the MongoDB.
          I have used userRepository*/

        UserEntity userEntity = userRepository.findFirstByLogin(username).
                orElseThrow(NoSuchElementException::new);

        UserDetails details = new SecUserDetails(userEntity);
        return details;

    }

    private UserEntity testUserForTry(){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("blank@blank");
        userEntity.setLogin("blank");
        userEntity.setPassword(encoder.encode("blank"));
        userEntity.setRole("API_USER");
        return userEntity;
        }

}

