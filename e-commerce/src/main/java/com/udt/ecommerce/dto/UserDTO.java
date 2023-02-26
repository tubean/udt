package com.udt.ecommerce.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private int roleId;
}
