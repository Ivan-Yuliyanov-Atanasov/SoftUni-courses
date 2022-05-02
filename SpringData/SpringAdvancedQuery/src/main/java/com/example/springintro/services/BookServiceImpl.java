package com.example.springintro.services;

import com.example.springintro.entities.Author;
import com.example.springintro.entities.Book;
import com.example.springintro.entities.Category;
import com.example.springintro.entities.enums.AgeRestriction;
import com.example.springintro.entities.enums.EditionType;
import com.example.springintro.repositories.BookRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
                .stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toList());
    }

        @Override
    public List<String> getAllBooksReleaseDateBefore(String date) {

        LocalDate releaseDate = LocalDate.parse(date,
                DateTimeFormatter.ofPattern("d/M/yyyy"));
        return bookRepository.findAllByReleaseDateBefore(releaseDate)
                .stream().map(b -> String.format("%s %s %s", b.getTitle(), b.getEditionType(), b.getPrice())).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public int increaseCopiesOfAllBooksReleaseDateAfter(LocalDate date, int number) {
        List<Book> books = bookRepository.findAllByReleaseDateAfter(date);
        books.forEach(b-> b.setCopies(b.getCopies() + number));
        return books.size()*number;
    }

    @Override
    public List<String> getAllBookTitlesWhichContain(String word) {
        return bookRepository.findAllByTitleContainingIgnoreCase(word).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllAuthorsLastNameStartsWith(String str) {
        return bookRepository.findAllByAuthor_LastNameStartsWith(str).stream()
                .map(b -> String.format("%s (%s %s)", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toList());
    }

    @Override
    public int getCountOfBooksWhoseTitleIsLongerThan(int titleLength) {
        return bookRepository.countAllBooksWithTitleLengthMoreThan(titleLength);
    }

    @Override
    public String getBookByTitle(String title) {
        Book book = bookRepository.findBookByTitle(title);
        return String.format("%s %s %s %s", book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice());
    }


    @Override
    public List<String> getBooksFromAuthor(String firstName, String lastName) {
        return bookRepository.findBooksByAuthor(firstName, lastName).stream()
                .map(b -> String.format("%s %s %d", b.getTitle(), b.getReleaseDate(), b.getCopies())).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBookTitlesByAgeRestriction(String ageRestrictionInput) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionInput);
        return bookRepository.findBooksByAgeRestriction(ageRestriction).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBookTitlesWhichAreGoldenEditionWithLessThan5000Copies(EditionType editionType, Integer numberOfCopies) {
        return bookRepository.findBooksByEditionTypeAndCopiesLessThan(editionType, numberOfCopies).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksWithPriceLowerThanFiveAndGreaterThanForty(BigDecimal price, BigDecimal price2) {
        return bookRepository.findBooksByPriceLessThanOrPriceGreaterThan(price, price2).stream()
                .map(b -> String.format("%s %s", b.getTitle(), b.getPrice())).collect(Collectors.toList());

    }

    @Override
    public List<String> getAllBookTitlesRealisedDateNotInYear(LocalDate dateBefore, LocalDate dateAfter) {
        return bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(dateBefore, dateAfter).stream()
                .map(Book::getTitle).collect(Collectors.toList());
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
