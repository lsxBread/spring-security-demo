package com.security.demo.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.security.demo.security.ApplicationUserAuthority.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(STUDENT_READ));

    private final Set<com.security.demo.security.ApplicationUserAuthority> applicationUserAuthorities;

    ApplicationUserRole(Set<com.security.demo.security.ApplicationUserAuthority> applicationUserAuthorities) {
        this.applicationUserAuthorities = applicationUserAuthorities;
    }

    public Set<com.security.demo.security.ApplicationUserAuthority> getApplicationUserAuthorities() {
        return applicationUserAuthorities;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = getApplicationUserAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
