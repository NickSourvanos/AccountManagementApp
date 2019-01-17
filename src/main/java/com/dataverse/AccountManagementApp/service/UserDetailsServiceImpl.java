package com.dataverse.AccountManagementApp.service;


import com.dataverse.AccountManagementApp.domain.User;
import com.dataverse.AccountManagementApp.repository.UserRepository;
import com.dataverse.AccountManagementApp.security.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // here we would search into the repo for the user.
        // for not we are just going to send always a successful response.
        User user = userRepository.findUserByEmail(username);

/*        List<SimpleGrantedAuthority> authorization = Collections.singletonList(new SimpleGrantedAuthority("ADMIN"));
        CharSequence password = "password";*/

        return new LoginResponse(user.getUserId(), user.getEmail(), user.getPass(),
                Arrays.asList(new SimpleGrantedAuthority(user.getRole().name())));


    }
}
