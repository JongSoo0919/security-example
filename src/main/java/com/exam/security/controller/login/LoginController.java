package com.exam.security.controller.login;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    @GetMapping("/view/login")
    public String login(
            HttpServletRequest request
    ) throws Exception {
        log.info("[view] request login page");
        return "/login/login";
    }

    @GetMapping("/view/join")
    public String join(
            HttpServletRequest request
    ) throws Exception {
        log.info("[view] request joing page");
        return "/login/join";
    }
}
