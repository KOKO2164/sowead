package com.sowead.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sowead.app.domain.User;

public interface UserRepository {
    List<User> getAll();
    Optional<User> getUser(int userId);
    User save(User user);
    void delete(int userId);
}
