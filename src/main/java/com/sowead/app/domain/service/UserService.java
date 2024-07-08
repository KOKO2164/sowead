package com.sowead.app.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowead.app.domain.User;
import com.sowead.app.domain.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int userId) {
        return userRepository.getUser(userId);
    }

    public List<User> getUserByActive() {
        List<User> users = userRepository.getAll();
        return users.stream().filter(User::isStatus).collect(Collectors.toList());
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(int userId, User user) {
        return getUser(userId).map(currentUser -> {
            currentUser.setName(user.getName());
            currentUser.setStatus(true);
            return userRepository.save(currentUser);
        }).orElse(null);
    }

    public User updateStatus(int userId, User user) {
        return getUser(userId).map(currentUser -> {
            currentUser.setStatus(false);
            return userRepository.save(currentUser);
        }).orElse(null);
    }

    public boolean delete(int userId) {
        return getUser(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
