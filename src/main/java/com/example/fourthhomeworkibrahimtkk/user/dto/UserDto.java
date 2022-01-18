package com.example.fourthhomeworkibrahimtkk.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String name;
    private String password;
}
