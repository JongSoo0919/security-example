package com.exam.security.controller.view.admin;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ROLE_ADMIN 권한을 지닌 유저만이 해당 Controller의 view를 사용 가능
 */
@Controller
@Slf4j
public class AdminController {
    @GetMapping("/view/admin/setting")
    public String getAdminSetting(
            HttpServletRequest request,
            Model model,
            @AuthenticationPrincipal User user
    ) throws Exception {
        return "/view/admin/setting";
    }
}
