package com.example.advancedspring.api.user;

import com.example.advancedspring.api.user.web.CreateUserDto;
import com.example.advancedspring.api.user.web.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User mapCreateUserDtoToUser(CreateUserDto createUserDto);
    UserDto mapUserToCreateUserDto(User user);

    List<UserDto> mapUserToUserDto(List<User> users);
}
