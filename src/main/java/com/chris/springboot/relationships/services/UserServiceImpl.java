package com.chris.springboot.relationships.services;

import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.models.UserProfile;
import com.chris.springboot.relationships.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User create(User user, UserProfile profile) {

        user.setUserProfile(profile);
        profile.setUser(user);
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


}
