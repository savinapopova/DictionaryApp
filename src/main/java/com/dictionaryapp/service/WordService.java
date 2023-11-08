package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.CreateWordDTO;
import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.enums.LanguageName;

import java.util.List;

public interface WordService {
    boolean register(CreateWordDTO createWordDTO);


//    List<WordDTO> geItalianWords();
//
//    List<WordDTO> geGermanWords();
//
//    List<WordDTO> geFrenchWords();

    List<WordDTO> getWords(LanguageName name);

    void deleteWord(Long id);

    void deleteAllWords();
}
