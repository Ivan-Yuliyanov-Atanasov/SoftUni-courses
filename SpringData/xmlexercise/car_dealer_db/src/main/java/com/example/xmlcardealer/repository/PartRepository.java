package com.example.xmlcardealer.repository;

import com.example.xmlcardealer.model.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
