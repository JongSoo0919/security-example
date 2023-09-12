package com.exam.security.controller;

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
        return "/login/login";
    }
}
