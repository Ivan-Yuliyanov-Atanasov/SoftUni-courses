package com.example.springintro.services;

import com.example.springintro.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> orderAuthorsByBooksSize();

    List<String> fullNamesOfAuthorWhoseFirstNameEndsWith(String nameEnding);

    List<String> AuthorsByTotalCopies();


}