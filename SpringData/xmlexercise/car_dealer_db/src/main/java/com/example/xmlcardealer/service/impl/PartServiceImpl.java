package com.example.xmlcardealer.service.impl;

import com.example.xmlcardealer.model.dto.importData.PartSeedDto;
import com.example.xmlcardealer.model.entity.Part;
import com.example.xmlcardealer.repository.PartRepository;
import com.example.xmlcardealer.service.PartService;
import com.example.xmlcardealer.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final SupplierService supplierService;

    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, SupplierService supplierService) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
    }


    @Override
    public void seedParts(List<PartSeedDto> parts) {

        if (partRepository.count() > 1) {
            return;
        }
        parts
                .stream()
                .map(PartSeedDto -> {
                    Part part = modelMapper.map(PartSeedDto, Part.class);
                    part.setSupplier(supplierService.findRandomSupplier());
                    return part;

                })
                .forEach(partRepository::save);
    }

    @Override
    public Set<Part> findRandomParts() {
        int randomCountOfParts = 10 + ThreadLocalRandom.current().nextInt(0, 11);
        Set<Part> parts = new HashSet<>();
        for (int i = 0; i < randomCountOfParts; i++) {
            long randomPartId = ThreadLocalRandom.current().nextLong(1, partRepository.count() + 1);
            parts.add(partRepository.findById(randomPartId).orElse(null));
        }
        return parts;
    }

}
