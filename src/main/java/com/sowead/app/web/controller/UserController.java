package com.sowead.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowead.app.domain.User;
import com.sowead.app.domain.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable("id") int userId, @RequestBody User user) {
        return userService.update(userId, user);
    }

    @PatchMapping("/update-status/{id}")
    public User updateStatus(@PathVariable("id") int userId, @RequestBody User user) {
        return userService.updateStatus(userId, user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int userId) {
        return userService.delete(userId);
    }
}
