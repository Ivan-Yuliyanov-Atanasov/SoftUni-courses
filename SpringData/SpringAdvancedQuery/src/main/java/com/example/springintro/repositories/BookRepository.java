package com.example.springintro.repositories;

import com.example.springintro.entities.Author;
import com.example.springintro.entities.enums.AgeRestriction;
import com.example.springintro.entities.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springintro.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate localDate);

    List<Book> findAllByReleaseDateBefore(LocalDate localDate);


    @Query("SELECT b from Book b WHERE b.author.firstName = :first_name AND b.author.lastName = :last_name order by b.releaseDate DESC, b.title")
    List<Book> findBooksByAuthor(@Param("first_name") String firstName, @Param("last_name") String lastName);

    List<Book> findBooksByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findBooksByEditionTypeAndCopiesLessThan(EditionType editionType, Integer numberOfCopies);

    List<Book> findBooksByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate dateBefore, LocalDate dateAfter);

    List<Book> findAllByTitleContainingIgnoreCase(String word);

    List<Book> findAllByAuthor_LastNameStartsWith(String author_lastName);

    @Query("SELECT count (b) FROM Book b Where length(b.title)  > :title_length")

    int countAllBooksWithTitleLengthMoreThan(@Param("title_length") int titleLength);

    Book findBookByTitle(String title);




}
