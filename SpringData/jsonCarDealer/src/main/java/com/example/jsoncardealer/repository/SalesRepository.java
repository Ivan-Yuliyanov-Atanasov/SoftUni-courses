package com.example.jsoncardealer.repository;

import com.example.jsoncardealer.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sale, Long> {
}
