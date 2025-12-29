package com.eps.service;

import com.eps.dao.UserRepository;
import com.eps.model.User;

public class AuthService {

    private UserRepository userRepo;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User login(String username, String password) {
        User user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
