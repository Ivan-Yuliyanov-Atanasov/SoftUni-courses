package com.example.springintro.services;

import com.example.springintro.entities.Author;
import com.example.springintro.entities.Book;
import com.example.springintro.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;


    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    @Override
    public void seedAuthors() throws IOException {

        if(authorRepository.count() > 0){
            return;
        }
        Files.readAllLines(Path.of("src/main/resources/files/authors.txt")).stream()
                .forEach(row -> {
                    String [] fullName = row.split("\\s++");
                    Author author = new Author(fullName[0], fullName[1]);
                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);
        return authorRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<String> orderAuthorsByBooksSize() {

        return authorRepository.findAll().stream()
                .sorted((a1, a2) -> Integer.compare(a2.getBooks().size(),a1.getBooks().size()))
                .map(author-> String.format("%s %s %d",author.getFirstName(), author.getLastName(), author.getBooks().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> fullNamesOfAuthorWhoseFirstNameEndsWith(String nameEnding) {
        return authorRepository.findAllByFirstNameEndingWith(nameEnding).stream().
                map(a -> String.format("%s %s",a.getFirstName(), a.getLastName())).collect(Collectors.toList());

    }

    @Override
    public List<String> AuthorsByTotalCopies() {
        return authorRepository.findAll().stream().sorted((a1,a2)-> Integer.compare(a2.getBooks().stream().mapToInt(Book::getCopies).sum(),a1.getBooks().stream().mapToInt(Book::getCopies).sum()))
                .map(a -> String.format("%s %s %d",a.getFirstName(),a.getLastName(),a.getBooks().stream().mapToInt(Book::getCopies).sum())).collect(Collectors.toList());
    }
}
