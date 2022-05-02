package com.example.springintro.services;

import com.example.springintro.entities.Author;
import com.example.springintro.entities.Book;
import com.example.springintro.entities.Category;
import com.example.springintro.entities.enums.AgeRestriction;
import com.example.springintro.entities.enums.EditionType;
import com.example.springintro.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of("src/main/resources/files/books.txt"))
                .stream()
                .forEach(row -> {
                    String[] tokens = row.split("\\s+");
                    Book book = createBook(tokens);
                    bookRepository.save(book);

                });
    }

    @Override
    public List<String> getAllBookTitles() {
        LocalDate releaseDate = LocalDate.parse("31/12/2000",
                DateTimeFormatter.ofPattern("d/M/yyyy"));
        return bookRepository.findAllByReleaseDateAfter(releaseDate)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllAuthors() {

        LocalDate releaseDate = LocalDate.parse("01/01/1990",
                DateTimeFormatter.ofPattern("d/M/yyyy"));
        return bookRepository.findAllByReleaseDateBefore(releaseDate)
                .stream().map(b -> String.format("%s %s",b.getAuthor().getFirstName(),b.getAuthor().getLastName())).collect(Collectors.toList());
    }

    @Override
    public List<String> getBooksFromAuthor(String firstName, String lastName) {
        return bookRepository.findBooksByAuthor(firstName, lastName).stream()
                .map(b-> String.format("%s %s %d", b.getTitle(), b.getReleaseDate(), b.getCopies())).collect(Collectors.toList());
    }

    private Book createBook(String[] tokens) {
        EditionType editionType = EditionType.values()[Integer.parseInt(tokens[0])];
        LocalDate releaseDate = LocalDate.parse(tokens[1],
                DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(tokens[2]);
        BigDecimal price = new BigDecimal(tokens[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(tokens[4])];
        String title = Arrays.stream(tokens)
                .skip(5)
                .collect(Collectors.joining(" "));
        Author author = authorService.getRandomAuthor();

        Set<Category> categories = categoryService.getRandomCategories();

        Book book = new Book(title, editionType, price, releaseDate,
                ageRestriction, author, categories, copies);

        return book;


    }
}
