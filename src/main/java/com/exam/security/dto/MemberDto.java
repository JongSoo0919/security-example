package com.exam.security.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String userId;
    private String password;
    private String name;
    private String email;
    private String roles;
}
