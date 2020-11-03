package com.example.Mansion;

import com.example.Mansion.entity.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationConfig {
    @Bean
    public Post postPrototype(){
        return new Post();
    }

}
