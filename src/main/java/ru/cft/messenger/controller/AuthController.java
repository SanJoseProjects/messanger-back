package ru.cft.messenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthController {

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("swagger-ui")
    public String getSwaggerUIPage() {
        return "swagger-ui.html";
    }
}
