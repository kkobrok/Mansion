package com.example.Mansion.config;

import com.example.Mansion.services.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
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
}
