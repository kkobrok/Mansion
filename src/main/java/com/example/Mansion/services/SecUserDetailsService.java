package com.example.Mansion.services;

import com.example.Mansion.entity.SecUserDetails;
import com.example.Mansion.entity.UserEntity;
import com.example.Mansion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class SecUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public SecUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Here add user data layer fetching from the MongoDB.
          I have used userRepository*/

        UserEntity userEntity = userRepository.findFirstByLogin(username).
                orElseThrow(NoSuchElementException::new);
        System.out.println("Present");
        System.out.println(userEntity.toString());
        return new SecUserDetails(userEntity);

    }

}

