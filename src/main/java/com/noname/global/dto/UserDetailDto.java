package com.noname.global.dto;

import com.noname.global.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailDto {
    private Integer userId;
    private UserRole role;
}
