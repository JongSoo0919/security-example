package com.exam.security.controller.view;

import com.exam.security.dto.user.request.UserRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class DashboardController {
    @GetMapping("/view/dashboard")
    public String dashboard(
            HttpServletRequest request,
            UserRequestDto userRequestDto,
            Model model
    ) throws Exception {
        model.addAttribute("user", userRequestDto);
        return "/dashboard";
    }
}
