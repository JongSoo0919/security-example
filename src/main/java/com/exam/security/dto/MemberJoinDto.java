package com.exam.security.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberJoinDto {
    private String userId;
    private String password;
    private String name;
    private String email;
    private String roles;

    @Builder
    public MemberJoinDto(String userId, String password, String name, String email, String roles) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }
}
