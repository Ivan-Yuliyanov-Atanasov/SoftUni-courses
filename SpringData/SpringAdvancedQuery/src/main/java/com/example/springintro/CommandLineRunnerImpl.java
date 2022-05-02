package com.example.springintro;

import com.example.springintro.entities.enums.EditionType;
import com.example.springintro.services.AuthorService;
import com.example.springintro.services.BookService;
import com.example.springintro.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;
    private static final DateTimeFormatter DATE_FORMAT_MONTH_SHORT_NAME = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

        selectExercise();

//        int inputNumber = querySelection();
//
//        query(inputNumber);
    }

    private void selectExercise() throws IOException {
        System.out.println("Please select exercise number:");
        int exerciseNumber = Integer.parseInt(bufferedReader.readLine());
        switch (exerciseNumber) {
            case 1:
                System.out.println("Please enter age restriction:");
                String ageRestriction = bufferedReader.readLine().toUpperCase();
                bookService.getAllBookTitlesByAgeRestriction(ageRestriction).forEach(System.out::println);
                break;
            case 2:
                bookService.getAllBookTitlesWhichAreGoldenEditionWithLessThan5000Copies(EditionType.GOLD, 5000)
                        .forEach(System.out::println);
            case 3:
                bookService.getAllBooksWithPriceLowerThanFiveAndGreaterThanForty(new BigDecimal(5), new BigDecimal(40))
                        .forEach(System.out::println);
                break;
            case 4:
                System.out.println("Please enter year:");
                int year = Integer.parseInt(bufferedReader.readLine());
                LocalDate dateBefore = LocalDate.of(year, 1, 1);
                LocalDate dateAfter = LocalDate.of(year, 12, 31);
                bookService.getAllBookTitlesRealisedDateNotInYear(dateBefore, dateAfter).forEach(System.out::println);
                break;

            case 5:
                System.out.println("Please enter date:");

                String date = bufferedReader.readLine().replace("-", "/");
                bookService.getAllBooksReleaseDateBefore(date).forEach(System.out::println);
                break;

            case 6:
                System.out.println("Please enter author's first name ending:");
                String nameEnding = bufferedReader.readLine();
                authorService.fullNamesOfAuthorWhoseFirstNameEndsWith(nameEnding).forEach(System.out::println);
                break;

            case 7:
                System.out.println("Please enter string:");
                String word = bufferedReader.readLine();
                bookService.getAllBookTitlesWhichContain(word).forEach(System.out::println);
                break;

            case 8:
                System.out.println("Please enter author's last name starting string:");
                String str = bufferedReader.readLine();
                bookService.getAllAuthorsLastNameStartsWith(str).forEach(System.out::println);
                break;

            case 9:
                System.out.println("Please enter title length:");
                int titleLength = Integer.parseInt(bufferedReader.readLine());
                System.out.println(bookService.getCountOfBooksWhoseTitleIsLongerThan(titleLength));
                break;

            case 10:
                authorService.AuthorsByTotalCopies().forEach(System.out::println);
                break;

            case 11:
                System.out.println("Please enter book title:");
                String bookTitle = bufferedReader.readLine();
                System.out.println(bookService.getBookByTitle(bookTitle));
                break;

            case 12:
                System.out.println("Please enter date:");
                LocalDate startDate = LocalDate.parse(bufferedReader.readLine().trim(), DATE_FORMAT_MONTH_SHORT_NAME);
                System.out.println("Please enter copies count:");
                int copiesCount = Integer.parseInt(bufferedReader.readLine());
                System.out.println(bookService.increaseCopiesOfAllBooksReleaseDateAfter(startDate,copiesCount));
                break;
        }
    }

    private void query(int inputNumber) {
        switch (inputNumber) {
            case 1:
                bookService.getAllBookTitles().forEach(System.out::println);
                break;
            case 2:
                bookService.getAllAuthors().forEach(System.out::println);
                break;
            case 3:
                authorService.orderAuthorsByBooksSize().forEach(System.out::println);
                break;
            case 4:
                bookService.getBooksFromAuthor("George", "Powell").forEach(System.out::println);
                break;
        }
    }

    private int querySelection() throws IOException {
        System.out.println("Please select number for the desired query:");
        System.out.println("1: For all books after 2000 year;");
        System.out.println("2: For all authors with at least one book with release date before 1990;");
        System.out.println("3: For all authors, ordered by the number of their books;");
        System.out.println("4: For books from author George Powell, ordered by their release date.");
        return Integer.parseInt(bufferedReader.readLine());
    }
}
