package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private WordService wordService;
    private UserService userService;

    public HomeController(WordService wordService, UserService userService) {
        this.wordService = wordService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {

        if (this.userService.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!this.userService.isLogged()) {
            return "redirect:/";
        }

        List<WordDTO > germanWords = this.wordService.getWords(LanguageName.GERMAN);
        int germanWordsCount = germanWords.size();
        List<WordDTO > spanishWords = this.wordService.getWords(LanguageName.SPANISH);
        int spanishWordsCount = spanishWords.size();
        List<WordDTO > frenchWords = this.wordService.getWords(LanguageName.FRENCH);
        int frenchWordsCount = frenchWords.size();
        List<WordDTO > italianWords = this.wordService.getWords(LanguageName.ITALIAN);
        int italianWordsCount = italianWords.size();

        int totalCount = germanWordsCount + spanishWordsCount + frenchWordsCount + italianWordsCount;

        model.addAttribute("totalCount", totalCount);

        model.addAttribute("germanWords", germanWords);
        model.addAttribute("spanishWords", spanishWords);
        model.addAttribute("frenchWords", frenchWords);
        model.addAttribute("italianWords", italianWords);

        model.addAttribute("germanWordsCount", germanWordsCount);
        model.addAttribute("spanishWordsCount", spanishWordsCount);
        model.addAttribute("frenchWordsCount", frenchWordsCount);
        model.addAttribute("italianWordsCount", italianWordsCount);


        return "home";
    }
}
