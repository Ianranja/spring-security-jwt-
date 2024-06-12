package com.example.security.dto;


import com.example.security.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

}
