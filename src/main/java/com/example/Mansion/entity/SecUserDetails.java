package com.example.Mansion.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SecUserDetails implements UserDetails {

    private UserEntity userEntity;
    private PasswordEncoder encoder;


    public SecUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
        encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("BASE_AUTHORITY"));
    }
    @Override
    public String getPassword() {
        return userEntity.password;
    }

    @Override
    public String getUsername() {
        return userEntity.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
