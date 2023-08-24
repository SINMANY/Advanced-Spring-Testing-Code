package com.example.advancedspring.api.user.web;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Builder
public record CreateUserDto (String name,
                            String gender,
                            Integer age) {
}
