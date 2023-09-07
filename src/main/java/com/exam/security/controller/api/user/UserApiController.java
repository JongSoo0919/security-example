package com.exam.security.controller.api.user;

import com.exam.security.dto.user.request.UserRequestDto;
import com.exam.security.dto.user.response.UserResponseDto;
import com.exam.security.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserApiController {
    private final UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<UserResponseDto> getUsers(
            HttpServletRequest request
    ) throws Exception {
        return  ResponseEntity.ok(UserResponseDto.builder()
                .id(1L)
                .email("test@gmail.com")
                .password("1234")
                .name("테스트")
                .build());
    }

    @PostMapping("/api/users")
    public ResponseEntity<Long> register(
            HttpServletRequest request,
            UserRequestDto userRequestDto
    ) throws Exception {
        Long id = userService.register(userRequestDto);

        return ResponseEntity.ok(id);
    }

    @PostMapping("/api/login-proc")
    public void loginProcess(
            HttpServletRequest request,
            UserRequestDto userRequestDto
    ) throws Exception {
        userService.validUser(userRequestDto);
    }
}
