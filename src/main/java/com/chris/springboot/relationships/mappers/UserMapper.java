package com.chris.springboot.relationships.mappers;

import com.chris.springboot.relationships.dto.user.UserCreateDTO;
import com.chris.springboot.relationships.dto.user.UserProfileCreateDTO;
import com.chris.springboot.relationships.models.User;
import com.chris.springboot.relationships.models.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userCreateDTOToUser(UserCreateDTO dto);
    UserProfile userProfileCreateDTOToUserProfile(UserProfileCreateDTO dto);

}
