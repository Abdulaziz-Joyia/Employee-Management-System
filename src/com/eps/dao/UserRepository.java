package com.eps.dao;

import com.eps.model.User;

public interface UserRepository {
    User findByUsername(String username);
}
