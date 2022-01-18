package com.example.fourthhomeworkibrahimtkk.user.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSaveRequest {

    private Long id;
    private String username;
    private String name;
    private String password;
}
