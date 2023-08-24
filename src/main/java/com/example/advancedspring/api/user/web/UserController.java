package com.example.advancedspring.api.user.web;

import com.example.advancedspring.api.test.Testing;
import com.example.advancedspring.api.user.User;
import com.example.advancedspring.api.user.UserService;
import com.example.advancedspring.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final Testing testing;

    @PostMapping
    public BaseRest<?> createUser(@PathVariable CreateUserDto createUserDto) {
        UserDto userDto = userService.createNewUser(createUserDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User created successfully")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }




    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        user.add(linkTo(methodOn(UserController.class)
                .findUserById(id)).withRel("find-user-id"));
        user.add(linkTo(methodOn(UserController.class)
                .findAllUser()).withRel("find-all-user"));
        return user;
    }

//    From SreyPhea

//    @GetMapping
//    public EntityModel<BaseRest<?>> selectAllUser() {
//       List<UserDto> userDtos = userService.findAllUser();
//        Link link = WebMvcLinkBuilder.linkTo((WebMvcLinkBuilder.methodOn(UserController.class)).selectAllUser()).withSelfRel();
//        EntityModel<BaseRest<?>> respondModel = EntityModel.of(
//                BaseRest.builder()
//                        .status(true)
//                        .code(HttpStatus.OK.value())
//                        .message("")
//                        .timestamp(LocalDateTime.now())
//                        .data(userDtos)
//                        .build()
//        );
//        respondModel.add(link);
//        return respondModel;
//    }


    //    User EntityModel
//    @GetMapping("/{id}")
//    EntityModel<User> findUserById(@PathVariable Integer id) {
//
//        User user = userService.findUserById(id);
////                .orElseThrow(() -> new EmployeeNotFoundException(id));
//
//        return EntityModel.of(user,
//                linkTo(methodOn(UserController.class).findUserById(id)).withSelfRel(),
//                linkTo(methodOn(UserController.class).findAllUser()).withRel("find-user-by-id"));
//    }

//    @GetMapping("/{id}")
//    public User findUserById(@PathVariable Integer id) {
//        return userService.findUserById(id);
//    }




    @GetMapping
    public List<User> findAllUser() {

        return userService.findAllUser();
    }

    @DeleteMapping("/delete/{id}")
    public User deletedUser(@PathVariable Integer id) {
        Integer deleteUser = userService.deleteUserById(id);
        return null;
    }

//    User Link and method add

//    @GetMapping("/list")
//    CollectionModel<?> all() {
//        List<User> users = userService.findAllUser();
//        users.forEach(user -> {
//            Link link1 = linkTo(methodOn(UserController.class).findAllUser()).withSelfRel();
//            Link link2 = linkTo(methodOn(UserController.class).findUserById(user.getId())).withRel("Find-User-ById");
//            Link link3 = linkTo(methodOn(UserController.class).deletedUser(user.getId())).withRel("Delete-User");
//            user.add(link1);
//            user.add(link2);
//            user.add(link3);
//        });
//        return CollectionModel.of(users,
//                linkTo(methodOn(UserController.class).all()).withSelfRel());
//    }


    //    Hateoas using CollectionModel
//    @GetMapping("/list")
//    CollectionModel<EntityModel<User>> all() {
//        List<EntityModel<User>> user = userService.findAllUser().stream()
//                .map(user1 -> EntityModel.of(user1,
//                        linkTo(methodOn(UserController.class).findUserById(user1.getId())).withRel("find-user-byId"),
//                        linkTo(methodOn(UserController.class).findAllUser()).withRel("find-all-user"))).collect(Collectors.toList());
//        return CollectionModel.of(user,
//                linkTo(methodOn(UserController.class).all()).withSelfRel());}

}
