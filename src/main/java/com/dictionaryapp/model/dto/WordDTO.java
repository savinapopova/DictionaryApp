package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.Word;

import java.time.LocalDate;

public class WordDTO {

    private Long id;

    private String term;

    private String translation;

    private String example;

    private String addedBy;

    private LocalDate inputDate;

    public WordDTO(Word word) {
        this.id = word.getId();
        this.term = word.getTerm();
        this.translation = word.getTranslation();
        this.example = word.getExample();
        this.addedBy = word.getAddedBy().getUsername();
        this.inputDate = word.getInputDate();
    }

    public WordDTO() {
    }

    public Long getId() {
        return id;
    }

    public WordDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public WordDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public WordDTO setAddedBy(String addedBy) {
        this.addedBy = addedBy;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public WordDTO setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }
}
