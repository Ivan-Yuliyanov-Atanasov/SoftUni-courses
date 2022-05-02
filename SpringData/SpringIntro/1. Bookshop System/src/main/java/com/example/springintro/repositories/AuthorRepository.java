package com.example.springintro.repositories;


import com.example.springintro.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Long> {


}
