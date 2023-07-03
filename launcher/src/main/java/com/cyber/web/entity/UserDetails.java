package com.cyber.web.entity;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UserDetails implements Principal {
    private String name;
    private String password;
    private Set<String> roles = new HashSet<>();

    public UserDetails() {
    }

    public UserDetails(String name, String password, Set<String> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return Collections.unmodifiableSet(roles);
    }
}
