package com.eagle.Event.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserEditDto {
    private Long id;
    private String username;
    private String lastName;
    private Date birthday;
    private String email;
    private String phone;
    private String password;
}
