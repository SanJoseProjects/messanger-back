package ru.cft.messenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("auth")
public class AuthController {

    @GetMapping("login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("swagger-ui")
    public ModelAndView getSwaggerUIPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("swagger-ui.html");
        return modelAndView;
    }
}
