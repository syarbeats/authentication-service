package com.mts.cdc.authenticationservice.services;

import com.mts.cdc.authenticationservice.entity.User;
import com.mts.cdc.authenticationservice.repository.UserRepository;
import com.mts.cdc.authenticationservice.utility.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServices implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        return new UserDetails(user);
    }
}
