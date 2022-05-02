package com.example.springintro;

import com.example.springintro.services.AuthorService;
import com.example.springintro.services.BookService;
import com.example.springintro.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

        int inputNumber = querySelection();

        query(inputNumber);
    }

    private void query(int inputNumber) {
        switch (inputNumber){
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
        return Integer.parseInt(reader.readLine());
    }
}
