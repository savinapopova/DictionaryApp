package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void seed() {
        if (this.languageRepository.count() == 0) {
            List<Language> languages = Arrays.stream(LanguageName.values())
                    .map(Language::new)
                    .collect(Collectors.toList());
            this.languageRepository.saveAll(languages);
        }
    }
}
