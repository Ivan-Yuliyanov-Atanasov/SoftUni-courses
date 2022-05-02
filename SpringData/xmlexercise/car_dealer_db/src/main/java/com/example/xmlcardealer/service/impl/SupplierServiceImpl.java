package com.example.xmlcardealer.service.impl;

import com.example.xmlcardealer.model.dto.export.SupplierViewDto;
import com.example.xmlcardealer.model.dto.export.SupplierViewRootDto;
import com.example.xmlcardealer.model.dto.importData.SupplierSeedDto;
import com.example.xmlcardealer.model.entity.Supplier;
import com.example.xmlcardealer.repository.SupplierRepository;
import com.example.xmlcardealer.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> suppliers) {
        if (supplierRepository.count() > 0) {
            return;
        }
        suppliers
                .stream()
                .map(supplierSeedDto -> modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(supplierRepository::save);
    }

    @Override
    public Supplier findRandomSupplier() {
        long randomId = ThreadLocalRandom.current().nextLong(1, supplierRepository.count() + 1);
        return supplierRepository.findById(randomId).orElse(null);
    }

    @Override
    public SupplierViewRootDto suppliersThatDoNotImport() {

        List<SupplierViewDto> suppliers = supplierRepository.findByIsImporterFalse()
                .stream()
                .map(supplier -> {
                    SupplierViewDto supplierViewDto = modelMapper.map(supplier, SupplierViewDto.class);
                    supplierViewDto.setPartsCount(supplier.getParts().size());
                    return supplierViewDto;
                }).collect(Collectors.toList());
        return new SupplierViewRootDto().setSuppliers(suppliers);
    }
}
