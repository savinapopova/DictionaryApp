package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private String translation;

    @Column(columnDefinition = "TEXT")
    private String example;

    @Column(name = "input_date", nullable = false)
    private LocalDate inputDate;

    @ManyToOne(optional = false)
    private Language language;

    @ManyToOne()
    private User addedBy;

    public Word(String term, String translation, String example,
                LocalDate inputDate, Language language, User addedBy) {
        this.term = term;
        this.translation = translation;
        this.example = example;
        this.inputDate = inputDate;
        this.language = language;
        this.addedBy = addedBy;
    }

    public Word() {
    }

    public Long getId() {
        return id;
    }

    public Word setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public Word setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public Word setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public Word setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public Word setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public Word setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public Word setAddedBy(User addedBy) {
        this.addedBy = addedBy;
        return this;
    }
}
