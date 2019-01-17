package com.dataverse.AccountManagementApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean userAutentication(String email, String pass) {
        return false;
    }
}
