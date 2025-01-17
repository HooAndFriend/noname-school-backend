package com.noname.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.noname.api.user.domain.User;

public interface UserJpaRepository extends JpaRepository<User, Integer>, UserJpaCustomRepository {
}
