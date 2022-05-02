package com.example.jsoncardealer.service;

import com.example.jsoncardealer.model.dto.SupplierViewDto;
import com.example.jsoncardealer.model.entity.Supplier;

import java.io.IOException;
import java.util.List;

public interface SupplierService {

    void seedSuppliers() throws IOException;

    Supplier findRandomSupplier();

    List<SupplierViewDto> suppliersThatDoNotImport();
}
