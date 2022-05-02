package com.example.springintro.services;

import com.example.springintro.entities.Author;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<String> getAllBookTitles();

    List<String> getAllAuthors();

    List<String> getBooksFromAuthor(String firstName, String lastName);
}
