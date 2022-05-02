package com.example.xmlcardealer.repository;

import com.example.xmlcardealer.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    List<Supplier> findByIsImporterFalse();
}
