package com.example.springintro.services;

import com.example.springintro.entities.Author;
import com.example.springintro.entities.Book;
import com.example.springintro.entities.enums.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<String> getAllBookTitles();

    List<String> getAllAuthors();

    List<String> getBooksFromAuthor(String firstName, String lastName);

    List<String> getAllBookTitlesByAgeRestriction(String ageRestriction);

    List<String> getAllBookTitlesWhichAreGoldenEditionWithLessThan5000Copies(EditionType editionType, Integer numberOfCopies);

    List<String> getAllBooksWithPriceLowerThanFiveAndGreaterThanForty(BigDecimal price, BigDecimal price2);

    List<String> getAllBookTitlesRealisedDateNotInYear(LocalDate dateBefore, LocalDate dateAfter);

    List<String> getAllBooksReleaseDateBefore(String date);

    List<String> getAllBookTitlesWhichContain(String word);

    List<String> getAllAuthorsLastNameStartsWith(String str);

    int getCountOfBooksWhoseTitleIsLongerThan(int titleLength);

    String getBookByTitle(String title);

    int increaseCopiesOfAllBooksReleaseDateAfter(LocalDate date, int number);
}
