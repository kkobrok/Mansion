package com.example.Mansion.config;

import com.example.Mansion.services.SecUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    SecUserDetailsService secUserDetailsService;


    @Autowired
    public SecurityConfig(SecUserDetailsService secUserDetailsService) {
        this.secUserDetailsService = secUserDetailsService;
    }

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(secUserDetailsService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/actuator", "/console*/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/users*/**").hasAnyRole("ADMIN", "API_USER")
                .antMatchers(HttpMethod.GET, "/api/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/**").hasRole("API_USER")
                .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("API_USER")
                .antMatchers("/hello", "/hello*").hasRole("HELLO_USER")
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



