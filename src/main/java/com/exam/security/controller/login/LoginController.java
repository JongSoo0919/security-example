package com.exam.security.controller.login;

import com.exam.security.dto.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    @GetMapping("/view/login")
    public String login(
            HttpServletRequest request
    ) throws Exception {
        return "/login/login";
    }

    @PostMapping("/api/login")
    public String loginProc(
            HttpServletRequest request,
            MemberDto dto
    ) throws Exception {
        if("user".equals(dto.getUserId())){
            return "/main/dashboard";
        }
        return "/login/login";
    }

    @GetMapping("/view/join")
    public String join(
            HttpServletRequest request
    ) throws Exception {
        return "/login/join";
    }
}
