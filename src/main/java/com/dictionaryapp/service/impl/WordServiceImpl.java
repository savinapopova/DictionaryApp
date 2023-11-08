package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.CreateWordDTO;
import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {

    private WordRepository wordRepository;

    private LanguageRepository languageRepository;

    private UserService userService;

    public WordServiceImpl(WordRepository wordRepository, LanguageRepository languageRepository, UserService userService) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userService = userService;
    }


    @Override
    public boolean register(CreateWordDTO createWordDTO) {
        Optional<Language> optionalLanguage = this.languageRepository
                .findByName(LanguageName.valueOf(createWordDTO.getLanguage()));
        if (optionalLanguage.isEmpty()) {
            return false;
        }
        Language language = optionalLanguage.get();
        User user = this.userService.getLoggedUser();

        Word word = new Word(createWordDTO.getTerm(),
                createWordDTO.getTranslation(),
                createWordDTO.getExample(),
                createWordDTO.getInputDate(),
                language,
                user);
        this.wordRepository.save(word);
        return true;
    }

//    @Override
//    public List<WordDTO> geItalianWords() {
//        List<Word> words = this.wordRepository.findAllByLanguageName(LanguageName.ITALIAN);
//        return words.stream().map(WordDTO::new)
//                .collect(Collectors.toList());
//    }
//
//
//    @Override
//    public List<WordDTO> geGermanWords() {
//        List<Word> words = this.wordRepository.findAllByLanguageName(LanguageName.GERMAN);
//        return words.stream().map(WordDTO::new)
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public List<WordDTO> geFrenchWords() {
//        List<Word> words = this.wordRepository.findAllByLanguageName(LanguageName.FRENCH);
//        return words.stream().map(WordDTO::new)
//                .collect(Collectors.toList());
//
//    }

    @Override
    public List<WordDTO> getWords(LanguageName name) {
        List<Word> words = this.wordRepository.findAllByLanguageName(name);
        return words.stream().map(WordDTO::new)
                .collect(Collectors.toList());

    }




    @Override
    public void deleteWord(Long id) {
        this.wordRepository.deleteById(id);
    }

    @Override
    public void deleteAllWords() {
        this.wordRepository.deleteAll();
    }
}
