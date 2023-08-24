package com.example.advancedspring.api.user;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends RepresentationModel<User> {

    private Integer id;

    private String name;

    private String gender;

    private Integer age;

    private Boolean isDeleted;

}