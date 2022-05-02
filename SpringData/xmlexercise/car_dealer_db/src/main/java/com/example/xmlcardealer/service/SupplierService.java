package com.example.xmlcardealer.service;

import com.example.xmlcardealer.model.dto.export.SupplierViewRootDto;
import com.example.xmlcardealer.model.dto.importData.SupplierSeedDto;
import com.example.xmlcardealer.model.entity.Supplier;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(List<SupplierSeedDto> suppliers);
    Supplier findRandomSupplier();

    SupplierViewRootDto suppliersThatDoNotImport();
}
