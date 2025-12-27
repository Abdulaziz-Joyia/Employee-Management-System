package com.eps.dao;

import com.eps.model.User;
import java.util.ArrayList;
import java.util.List;

public class FileUserRepository implements UserRepository {

    private List<User> users = new ArrayList<>();

    public FileUserRepository() {
        users.add(new User("admin", "admin123", "ADMIN"));
        users.add(new User("user", "user123", "USER"));
    }

    @Override
    public User findByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
