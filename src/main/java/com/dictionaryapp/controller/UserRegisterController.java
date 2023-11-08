package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.UserRegisterDTO;
import com.dictionaryapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRegisterController {

    private UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public UserRegisterDTO init() {
        return new UserRegisterDTO();
    }

    @GetMapping("/users/register")
    public String register() {

        if (this.userService.isLogged()) {
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/users/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (this.userService.isLogged()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO",
                            bindingResult);
            return "redirect:/users/register";
        }
        this.userService.register(userRegisterDTO);
        return "redirect:/users/login";
    }
}
