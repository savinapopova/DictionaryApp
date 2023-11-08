package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public UserLoginDTO init() {
        return new UserLoginDTO();
    }

    @GetMapping("/users/login")
    public String login() {

        if (this.userService.isLogged()) {
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping("/users/login")
    public String login(@Valid UserLoginDTO userLoginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (this.userService.isLogged()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO",
                    bindingResult);

            return "redirect:/users/login";
        }

        if (!this.userService.login(userLoginDTO)) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("noSuchUser", true);

            return "redirect:/users/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {

        if (!this.userService.isLogged()) {
            return "redirect:/";
        }
        this.userService.logout();
        return "redirect:/";
    }
}
