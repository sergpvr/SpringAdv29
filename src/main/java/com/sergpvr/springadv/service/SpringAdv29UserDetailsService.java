package com.sergpvr.springadv.service;

import beans.models.User;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringAdv29UserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userService.getUsersByName(username).stream().findFirst().orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new SpringAdv29UserPrincipal(user);
    }
}
