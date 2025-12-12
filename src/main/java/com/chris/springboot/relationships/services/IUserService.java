package com.chris.springboot.relationships.services;

import com.chris.springboot.relationships.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User create(User user);
    List<User> findAll();
    Optional<User> findById(Long id);


}
