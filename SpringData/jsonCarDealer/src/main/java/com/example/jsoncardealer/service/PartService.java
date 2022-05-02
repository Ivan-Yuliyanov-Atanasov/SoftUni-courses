package com.example.jsoncardealer.service;

import com.example.jsoncardealer.model.entity.Part;

import java.io.IOException;
import java.util.Set;

public interface PartService {

    void seedParts() throws IOException;

    Set<Part> findRandomParts();
}
