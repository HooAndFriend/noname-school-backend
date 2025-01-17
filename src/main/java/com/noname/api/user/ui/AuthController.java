package com.noname.api.user.ui;

import com.noname.api.user.event.dto.RequestTokenReissueDto;
import com.noname.api.user.event.dto.RequestUserLoginDto;
import com.noname.api.user.event.dto.RequestUserSaveDto;
import com.noname.api.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.noname.global.dto.SwaggerExampleValue;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth API", description = "인증 관련 API")
@Slf4j
public class AuthController {
    private final UserService userService;

    @Operation(summary = "Save User", description = "회원가입, 아이디와 비밀번호를 받아 유효성 및 중복 검사 후 유저를 저장합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입에 성공하였습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.USER_SAVE_RESPONSE))),
            @ApiResponse(responseCode = "400", description = "이미 사용 중인 아이디 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerExampleValue.USER_SAVE_EXISTED_NUMBER_RESPONSE)})),
            @ApiResponse(responseCode = "500", description = "서버에서 에러가 발생하였습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.INTERNAL_SERVER_ERROR_RESPONSE)))})
    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody RequestUserSaveDto dto) {
        return userService.saveUser(dto);
    }

    @Operation(summary = "Login", description = "로그인, 아이디와 비밀번호를 받아 유효성 및 유저 조회, 비밀번호 검증 후 토큰을 발급합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인에 성공했습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.USER_LOGIN_RESPONSE))),
            @ApiResponse(responseCode = "400", description = "비밀번호가 같지 않습니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerExampleValue.USER_LOGIN_NOT_MATCH_PASSWORD_RESPONSE)})),
            @ApiResponse(responseCode = "404", description = "유저를 찾을 수 없습니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = SwaggerExampleValue.USER_LOGIN_NOT_FOUND_RESPONSE)})),
            @ApiResponse(responseCode = "500", description = "서버에서 에러가 발생하였습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.INTERNAL_SERVER_ERROR_RESPONSE)))})
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody RequestUserLoginDto dto) {
        return userService.loginUser(dto);
    }

    @Operation(summary = "Reissue Token", description = "토큰 재발급, refresh token 유효성 검사 후 토큰을 재발급 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "토큰을 재발급 받습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.REISSUE_TOKEN_RESPONSE))),
            @ApiResponse(responseCode = "500", description = "서버에서 에러가 발생하였습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.INTERNAL_SERVER_ERROR_RESPONSE)))})
    @PostMapping("/reissue")
    public ResponseEntity<?> reissueToken(@Valid @RequestBody RequestTokenReissueDto dto) {
        return userService.reissueToken(dto);
    }
}
