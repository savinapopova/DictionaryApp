package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private LanguageName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language", targetEntity = Word.class)
    private List<Word> words;

    public Language(LanguageName name) {
        this.name = name;
        setDescription(name);
        this.words = new ArrayList<>();
    }

    public Language() {
        this.words = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Language setId(Long id) {
        this.id = id;
        return this;
    }

    public LanguageName getName() {
        return name;
    }

    public Language setName(LanguageName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Language setDescription(LanguageName name) {

        description = null;
        switch (name) {
            case GERMAN:
                description = "A West Germanic language, is spoken by over 90 million people worldwide. " +
                        "Known for its complex grammar and compound words," +
                        " it's the official language of Germany and widely used in Europe.";
                break;
            case SPANISH:
                description = "A Romance language, is spoken by over 460 million people worldwide. " +
                        "It boasts a rich history," +
                        " diverse dialects, and is known for its melodious sound," +
                        " making it a global cultural treasure.";
                break;
            case FRENCH:
                description = "A Romance language spoken worldwide, known for its elegance and cultural richness. " +
                        "It's the official language of France and numerous nations, famed for its cuisine, art, " +
                        "and literature.";
            case ITALIAN:
                description = "A Romance language spoken in Italy and parts of Switzerland," +
                        " with rich cultural heritage. " +
                        "Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";
                break;

        }
        this.description = description;

        return this;
    }
}
