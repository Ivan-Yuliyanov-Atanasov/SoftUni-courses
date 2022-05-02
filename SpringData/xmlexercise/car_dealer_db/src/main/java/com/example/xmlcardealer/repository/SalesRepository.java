package com.example.xmlcardealer.repository;

import com.example.xmlcardealer.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sale, Long> {

}
