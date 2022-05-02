package com.example.xmlcardealer.service;

import com.example.xmlcardealer.model.dto.importData.PartSeedDto;
import com.example.xmlcardealer.model.dto.importData.SupplierSeedDto;
import com.example.xmlcardealer.model.entity.Part;

import java.util.List;
import java.util.Set;

public interface PartService {

    void seedParts(List<PartSeedDto> parts);

    Set<Part> findRandomParts();
}
