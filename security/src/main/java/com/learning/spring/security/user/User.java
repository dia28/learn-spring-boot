package com.learning.spring.security.user;

import jakarta.validation.constraints.NotNull;

public class User {

    @NotNull(message = "is required")
    private String userName;

    @NotNull(message = "is required")
    private String password;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
