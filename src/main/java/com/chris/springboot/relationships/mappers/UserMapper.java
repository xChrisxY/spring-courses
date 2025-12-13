package com.chris.springboot.relationships.mappers;

import com.chris.springboot.relationships.dto.user.UserCreateDTO;
import com.chris.springboot.relationships.dto.user.UserProfileCreateDTO;
import com.chris.springboot.relationships.dto.user.UserUpdateDTO;
import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.models.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "passwordHash", source = "password")
    User userCreateDTOToUser(UserCreateDTO dto);
    UserProfile userProfileCreateDTOToUserProfile(UserProfileCreateDTO dto);

    @Mapping(target = "passwordHash", source = "password")
    User userUpdateDTOtoUser(UserUpdateDTO dto);
}
