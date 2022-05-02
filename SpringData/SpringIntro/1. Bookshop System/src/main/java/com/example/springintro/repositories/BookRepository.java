package com.example.springintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springintro.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate localDate);

    List<Book> findAllByReleaseDateBefore(LocalDate localDate);


    @Query("SELECT b from Book b WHERE b.author.firstName = :first_name AND b.author.lastName = :last_name order by b.releaseDate DESC, b.title")

    List<Book> findBooksByAuthor(@Param("first_name") String firstName, @Param("last_name") String lastName);


}
