package com.exam.security.controller.view.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class UserViewController {
    @GetMapping("/view/login")
    public String login(
            HttpServletRequest request,
            Model model
    ) throws Exception {
        return "/user/login";
    }

}
