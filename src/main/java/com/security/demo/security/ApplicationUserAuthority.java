package com.security.demo.security;

public enum ApplicationUserAuthority {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write");

    private final String authority;

    ApplicationUserAuthority(String authority) {this.authority = authority; }

    public String getAuthority() {
        return this.authority;
    }
}
