package com.example.advancedspring.api.user.web;

import lombok.Builder;
import lombok.Data;

@Builder
public record UserDto(String name,
                      String gender,
                      Integer age,
                      Boolean isDeleted) {
}
