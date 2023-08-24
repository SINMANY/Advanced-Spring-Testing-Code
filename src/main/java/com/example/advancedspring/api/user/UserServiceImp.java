package com.example.advancedspring.api.user;

import com.example.advancedspring.api.user.web.CreateUserDto;
import com.example.advancedspring.api.user.web.UserDto;
import lombok.RequiredArgsConstructor;;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserMapper userMapper;

    private final UserMapStruct userMapStruct;
    @Override
    public UserDto createNewUser(CreateUserDto createUserDto) {
        User user = userMapStruct.mapCreateUserDtoToUser(createUserDto);
        userMapper.insert(user);
        return userMapStruct.mapUserToCreateUserDto(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectUserById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Student with id %d is not found!", id)));
    }

    @Override
    public List<User> findAllUser() {
       return userMapper.select();
    }

    @Override
    public Integer deleteUserById(Integer id) {
        boolean isExisted = userMapper.isExistedById(id);
        if (isExisted){
            userMapper.deletedById(id);
            return id;
        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                String.format("Class with ID %d is not found!", id));
        return null;
    }


}
