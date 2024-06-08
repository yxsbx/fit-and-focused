package com.fitandfocused.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
}