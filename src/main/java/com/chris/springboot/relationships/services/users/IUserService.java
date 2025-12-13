package com.chris.springboot.relationships.services.users;

import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.models.UserProfile;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User create(User user, UserProfile profile);
    List<User> findAll();
    Optional<User> findById(Long id);
    User update(Long id, User data);
    String encryptPassword(String password);
    void delete(Long id);

}
