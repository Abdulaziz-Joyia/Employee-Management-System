package com.eps.model;

public class User {
    private final String username;
    private final String password;
    private final String role; // ADMIN or USER

    public  User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    // ✅ Getter methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password; // <- This fixes AuthService error
    }

    public String getRole() {
        return role;
    }
}
