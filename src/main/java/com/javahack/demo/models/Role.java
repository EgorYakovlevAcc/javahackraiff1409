package com.javahack.demo.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("USER"),
    ADMIN("ADMIN");

    private String authority;


    Role(String name) {
        this.authority = name;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
