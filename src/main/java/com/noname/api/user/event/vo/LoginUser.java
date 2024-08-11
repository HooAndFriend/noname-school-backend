package com.noname.api.user.event.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginUser {
    private Integer userId;
    private String username;
    private String password;
}
