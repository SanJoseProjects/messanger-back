package ru.cft.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.cft.messenger.repository.model.Users;
import ru.cft.messenger.security.UserDetailsServiceImpl;

@RestController
@RequestMapping("auth")
public class RegistrationController {

    private UserDetailsServiceImpl userService;

    @Autowired
    public RegistrationController(UserDetailsServiceImpl userDetailsService) {
        this.userService = userDetailsService;
    }

    @GetMapping("/registration")
    public ModelAndView registration(Model model) {
        model.addAttribute("userForm", new Users());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@RequestBody @ModelAttribute("userForm") Users userForm, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            return modelAndView;
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            modelAndView.setViewName("registration");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/api/login");
        return modelAndView;
    }
}
