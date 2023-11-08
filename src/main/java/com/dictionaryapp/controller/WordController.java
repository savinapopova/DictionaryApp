package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.CreateWordDTO;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WordController {

    private WordService wordService;
    private UserService userService;

    public WordController(WordService wordService, UserService userService) {
        this.wordService = wordService;
        this.userService = userService;
    }

    @ModelAttribute
    public CreateWordDTO init() {
        return new CreateWordDTO();
    }

    @GetMapping("/words/add")
    public String addWord() {

        if (!this.userService.isLogged()) {
            return "redirect:/";
        }
        return "word-add";
    }

    @PostMapping("/words/add")
    public String addWord(@Valid CreateWordDTO createWordDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (!this.userService.isLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createWordDTO", createWordDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.createWordDTO",
                            bindingResult);
            return "redirect:/words/add";
        }

        if (!this.wordService.register(createWordDTO)) {
            redirectAttributes.addFlashAttribute("createWordDTO", createWordDTO);
            redirectAttributes
                    .addFlashAttribute("noSuchLanguage",true);
            return "redirect:/words/add";
        }
        return "redirect:/home";
    }

    @GetMapping("/words/delete/{id}")
    public String deleteWord(@PathVariable Long id) {
        if (!this.userService.isLogged()) {
            return "redirect:/";
        }

        this.wordService.deleteWord(id);
        return "redirect:/home";
    }

    @GetMapping("/words/remove/all")
    public String deleteAllWords() {

        if (!this.userService.isLogged()) {
            return "redirect:/";
        }
        this.wordService.deleteAllWords();
        return "redirect:/home";
    }
}
