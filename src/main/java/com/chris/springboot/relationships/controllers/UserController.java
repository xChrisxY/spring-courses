package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.dto.user.*;
import com.chris.springboot.relationships.mappers.UserMapper;
import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.models.UserProfile;
import com.chris.springboot.relationships.services.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper mapper;

    @GetMapping("/")
    public ResponseEntity<ListResponseDTO> list() {

        List<User> users = userService.findAll();
        List<UserResponseDTO> responseDTOS = new ArrayList<>();

        users.forEach(user -> {

            responseDTOS.add(
            new UserResponseDTO(
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getUserProfile().getFirstName(),
                user.getUserProfile().getLastName(),
                user.getUserProfile().getAge(),
                user.getUserProfile().getAvatarUrl()
            ));

        });

        ListResponseDTO response = new ListResponseDTO(
                true,
                "Usuarios obtenidos existosamente",
                200,
                responseDTOS
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> show(@PathVariable Long id) {

        Optional<User> optionalUser = userService.findById(id);
        ResponseDTO response = new ResponseDTO();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            response.setSuccess(true);
            response.setMessage("User obtained successfully");
            response.setStatus(200);

            UserResponseDTO obtainedUser = new UserResponseDTO(
                    user.getUsername(),
                    user.getEmail(),
                    user.getRole(),
                    user.getUserProfile().getFirstName(),
                    user.getUserProfile().getLastName(),
                    user.getUserProfile().getAge(),
                    user.getUserProfile().getAvatarUrl()
            );

            response.setUser(obtainedUser);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        response.setSuccess(false);
        response.setMessage("User not found");
        response.setStatus(404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(response);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> create(@RequestBody UserCreateDTO dto) {

        User user = mapper.userCreateDTOToUser(dto);
        UserProfile profile = mapper.userProfileCreateDTOToUserProfile(dto.getProfile());

        User newUser = userService.create(user, profile);

        UserResponseDTO createdUser = new UserResponseDTO(
                newUser.getUsername(),
                newUser.getEmail(),
                newUser.getRole(),
                newUser.getUserProfile().getFirstName(),
                newUser.getUserProfile().getLastName(),
                newUser.getUserProfile().getAge(),
                newUser.getUserProfile().getAvatarUrl()
        );

        ResponseDTO response = new ResponseDTO(
                true,
                "Usuario creado correctamente",
                200,
                createdUser
        );

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @RequestBody UserUpdateDTO dto){

        User user = mapper.userUpdateDTOtoUser(dto);
        User updatedUser = userService.update(id, user);

        UserResponseDTO createdUser = new UserResponseDTO(
                updatedUser.getUsername(),
                updatedUser.getEmail(),
                updatedUser.getRole(),
                updatedUser.getUserProfile().getFirstName(),
                updatedUser.getUserProfile().getLastName(),
                updatedUser.getUserProfile().getAge(),
                updatedUser.getUserProfile().getAvatarUrl()
        );

        ResponseDTO response = new ResponseDTO(
                true,
                "Usuario actualizado correctamente",
                200,
                createdUser
        );

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponseDTO> delete(@PathVariable Long id){

        userService.delete(id);

        DeleteResponseDTO response = new DeleteResponseDTO();

        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

}
