package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.dto.user.UserCreateDTO;
import com.chris.springboot.relationships.mappers.UserMapper;
import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.models.UserProfile;
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

    @Autowired
    private UserMapper mapper;

    @GetMapping("/")
    public List<User> list() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> show(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/")
    public Map<String, Object> create(@RequestBody UserCreateDTO dto) {

        User user = mapper.userCreateDTOToUser(dto);
        UserProfile profile = mapper.userProfileCreateDTOToUserProfile(dto.getProfile());

        User newUser = userService.create(user, profile);
        System.out.println(newUser);

        Map<String, Object> users = new HashMap<>();
        users.put("Name", "Chris");
        return users;
    }

}
