package com.example.jsoncardealer.service.impl;


import com.example.jsoncardealer.model.dto.SupplierSeedDto;

import com.example.jsoncardealer.model.dto.SupplierViewDto;
import com.example.jsoncardealer.model.entity.Supplier;
import com.example.jsoncardealer.repository.SupplierRepository;
import com.example.jsoncardealer.service.SupplierService;
import com.example.jsoncardealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    public static final String SUPPLIERS_FILE_PATH = "src/main/resources/files/suppliers.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedSuppliers() throws IOException {
        if (supplierRepository.count() > 0) {
            return;
        }

        String categoryFileContent = Files.readString(Path.of(SUPPLIERS_FILE_PATH));

        SupplierSeedDto[] supplierSeedDtos = gson.fromJson(categoryFileContent, SupplierSeedDto[].class);
        Arrays.stream(supplierSeedDtos).filter(validationUtil::isValid).
                map(supplierSeedDto ->
                    modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(supplierRepository::save);


    }

    @Override
    public Supplier findRandomSupplier() {
        long randomId = ThreadLocalRandom.current().nextLong(1, supplierRepository.count() + 1);
        return supplierRepository.findById(randomId).orElse(null);
    }

    @Override

    public List<SupplierViewDto> suppliersThatDoNotImport() {
        return supplierRepository.findByIsImporterFalse().stream()
                .map(supplier -> {
                    SupplierViewDto supplierViewDto = modelMapper.map(supplier, SupplierViewDto.class);
                    supplierViewDto.setPartsCount(supplier.getParts().size());
                    return supplierViewDto;
                }).collect(Collectors.toList());
    }
}
