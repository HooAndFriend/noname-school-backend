package com.noname.global.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import com.noname.global.dto.UserDetailDto;


@Slf4j
public class PermissionUtils {

    public static UserDetailDto getUserDetailDto(HttpServletRequest httpServletRequest) {
        return (UserDetailDto) httpServletRequest.getAttribute("user");
    }
}
