package com.exam.security.controller.login;

import com.exam.security.dto.MemberJoinDto;
import com.exam.security.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final MemberService memberService;

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
        log.info("[view] request join page");
        return "/login/join";
    }

    @PostMapping("/api/join")
    @ResponseBody
    public ResponseEntity<Long> join(
            HttpServletRequest request,
            @RequestBody MemberJoinDto dto
    ) throws Exception {
        log.info("[api] request join api");
        Long id  = memberService.join(dto);

        return ResponseEntity.ok(id);
    }
}
