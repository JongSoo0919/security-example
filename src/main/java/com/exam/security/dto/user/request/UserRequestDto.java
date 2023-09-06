package com.exam.security.dto.user.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {
    private Long id;
    private String email;
    private String password;
    private String name;

    @Builder
    public UserRequestDto(Long id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
