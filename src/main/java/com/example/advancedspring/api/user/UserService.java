package com.example.advancedspring.api.user;

import com.example.advancedspring.api.user.web.CreateUserDto;
import com.example.advancedspring.api.user.web.UserDto;

import java.util.List;

public interface UserService {

    UserDto createNewUser(CreateUserDto createUserDto);
    User findUserById(Integer id);
    List<User> findAllUser();
    Integer deleteUserById(Integer id);
}
