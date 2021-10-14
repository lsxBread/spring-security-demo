package com.security.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUsersService implements UserDetailsService {
    @Autowired
    private ApplicationUserDao applicationUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // use the username to find out a user from database
        return applicationUserDao
                .getApplicationUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
