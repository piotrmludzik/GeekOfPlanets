package com.codecool.geekofplanets.security;

public class UserCredentials {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("UserCredentials[username='%s', password='%s']", username, password);
    }
}
