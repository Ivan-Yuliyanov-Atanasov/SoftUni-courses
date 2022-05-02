package com.example.jsoncardealer.repository;

import com.example.jsoncardealer.model.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part,Long> {
}
