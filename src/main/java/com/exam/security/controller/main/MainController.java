package com.exam.security.controller.main;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
    @GetMapping("/status")
    @ResponseBody
    public ResponseEntity<HttpStatus> getStatus(){
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/view/dashboard")
    public String dashboard(
            HttpServletRequest request
    ) throws Exception {
        return "/main/dashboard";
    }
}
