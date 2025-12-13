package com.chris.springboot.relationships.services.users;

import com.chris.springboot.relationships.exceptions.UserNotFoundException;
import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.models.UserProfile;
import com.chris.springboot.relationships.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public User create(User user, UserProfile profile) {

        String passwordHash = encryptPassword(user.getPasswordHash());
        user.setPasswordHash(passwordHash);

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

    @Transactional
    @Override
    public User update(Long id, User userData) {

        User user = findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado: " + id));

        String passwordHash = encryptPassword(userData.getPasswordHash());

        user.setUsername(userData.getUsername());
        user.setEmail(userData.getUsername());
        user.setPasswordHash(passwordHash);
        user.setRole(userData.getRole());
        return userRepository.save(user);

    }

    @Override
    public String encryptPassword(String password){
        return passwordEncoder.encode(password);
    }

    @Override
    public void delete(Long id){

        User user = findById(id).
                orElseThrow(() -> new UserNotFoundException("Usuario no encontrado: " + id));

        userRepository.delete(user);

    }

}
