package com.example.jsoncardealer.service.impl;

import com.example.jsoncardealer.model.dto.PartSeedDto;

import com.example.jsoncardealer.model.entity.Part;

import com.example.jsoncardealer.repository.PartRepository;
import com.example.jsoncardealer.service.PartService;
import com.example.jsoncardealer.service.SupplierService;
import com.example.jsoncardealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final SupplierService supplierService;
    public static final String PARTS_FILE_PATH = "src/main/resources/files/parts.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedParts() throws IOException {
        if (partRepository.count() > 0) {
            return;
        }

        String categoryFileContent = Files.readString(Path.of(PARTS_FILE_PATH));

        PartSeedDto[] partSeedDtos = gson.fromJson(categoryFileContent, PartSeedDto[].class);
        Arrays.stream(partSeedDtos).filter(validationUtil::isValid).
                map(partSeedDto -> {
                    Part part = modelMapper.map(partSeedDto, Part.class);
                    part.setSupplier(supplierService.findRandomSupplier());
                    return part;
                })

                .forEach(partRepository::save);
    }

    @Override
    public Set<Part> findRandomParts() {

        int randomCountOfParts = 3 + ThreadLocalRandom.current().nextInt(0 ,3);
        Set<Part> parts = new HashSet<>();
        for (int i = 0; i < randomCountOfParts; i++) {
            long randomPartId = ThreadLocalRandom.current().nextLong(1, partRepository.count() + 1);
            parts.add(partRepository.findById(randomPartId).orElse(null));
        }
        return parts;
    }
}
