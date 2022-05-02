package com.example.jsoncardealer.repository;

import com.example.jsoncardealer.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {


    List<Supplier> findByIsImporterFalse();
}
