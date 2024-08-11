package com.noname.api.user.repository;


import com.noname.api.user.event.vo.LoginUser;

public interface UserJpaCustomRepository {
    boolean existByUsername(String username);

    LoginUser findUserByUsername(String username);
}
