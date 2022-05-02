package com.example.football.service.impl;

import com.example.football.models.dto.TownImportDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Service
public class TownServiceImpl implements TownService {

    public static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return this.townRepository.count() > 1;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        TownImportDTO[] towns = gson.fromJson(new FileReader(TOWNS_FILE_PATH), TownImportDTO[].class);

        Arrays.stream(towns)
                .forEach(townImportDTO -> {
                    if (!validatorUtil.isValid(townImportDTO)) {
                        sb.append("Invalid Town");

                    } else {

                        this.townRepository.save(modelMapper.map(townImportDTO, Town.class));
                        sb.append(String.format("Successfully imported Town %s - %d",townImportDTO.getName(), townImportDTO.getPopulation()));


                    }

                    sb.append(System.lineSeparator());
                });


        return sb.toString().trim();
    }

    @Override
    public Town findTownByName(String name) {
        return this.townRepository.findByName(name);
    }
}
