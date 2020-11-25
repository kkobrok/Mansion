package com.example.Mansion.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public abstract class AbstractSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected PasswordEncoder encoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/actuator", "/console*/**").permitAll()
                .antMatchers("/").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/users*/**").hasAnyRole("ADMIN", "API_USER")
//                .antMatchers(HttpMethod.GET, "/api/**").authenticated()
//                .antMatchers(HttpMethod.POST, "/api/**").hasRole("API_USER")
//                .antMatchers(HttpMethod.PUT, "/api/**").hasRole("API_USER")
//                .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("API_USER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .httpBasic()
                .and()
            .headers()
                .frameOptions()
                .sameOrigin()
                .and()
            .csrf()
                .disable();
    }
}
