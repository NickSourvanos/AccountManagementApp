package com.dataverse.AccountManagementApp.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class LoginResponse extends User {

    private Long userId;

    public LoginResponse(Long userId, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
