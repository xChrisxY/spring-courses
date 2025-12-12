package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public List<User> list() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> show(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public Map<String, Object> create() {

        Map<String, Object> user = new HashMap<>();
        user.put("Name", "Chris");
        return user;
    }

}
