package ru.cft.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cft.messenger.repository.model.Users;
import ru.cft.messenger.security.UserDetailsServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("auth")
public class RegistrationController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Users());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestBody @ModelAttribute("userForm") Users userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/auth/login";
    }
}
