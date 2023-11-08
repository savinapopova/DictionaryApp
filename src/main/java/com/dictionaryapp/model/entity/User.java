package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "addedBy")
    private List<Word> addedWords;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.addedWords = new ArrayList<>();
    }

    public User() {
        this.addedWords = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Word> getAddedWords() {
        return addedWords;
    }

    public User setAddedWords(List<Word> addedWords) {
        this.addedWords = addedWords;
        return this;
    }
}
