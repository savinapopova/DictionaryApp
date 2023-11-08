package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.Language;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateWordDTO {

    @NotBlank
    @Size(min = 2, max = 40)
    private String term;

    @NotBlank
    @Size(min = 2, max = 80)
    private String translation;


    @Size(min = 2, max = 200)
    private String example;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputDate;

    @NotBlank
    private String language;

    public String getTerm() {
        return term;
    }

    public CreateWordDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public CreateWordDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public CreateWordDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public CreateWordDTO setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public CreateWordDTO setLanguage(String language) {
        this.language = language;
        return this;
    }
}
