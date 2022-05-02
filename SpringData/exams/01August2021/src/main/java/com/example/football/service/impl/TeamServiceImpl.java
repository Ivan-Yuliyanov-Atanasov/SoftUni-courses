package com.example.football.service.impl;

import com.example.football.models.dto.TeamImportDTO;

import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
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
public class TeamServiceImpl implements TeamService {
    public static final String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final TownService townService;

    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, TownService townService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 1;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TeamImportDTO[] teams = gson.fromJson(new FileReader(TEAMS_FILE_PATH), TeamImportDTO[].class);

        Arrays.stream(teams)
                .forEach(teamImportDTO -> {
                    if (!validatorUtil.isValid(teamImportDTO) || (this.teamRepository.findByName(teamImportDTO.getName()) != null)) {
                        sb.append("Invalid Team");
                    } else {
                        Town town = townService.findTownByName(teamImportDTO.getTownName());
                        Team team = modelMapper.map(teamImportDTO, Team.class).setTown(town);
                        this.teamRepository.save(team);
                        sb.append(String.format("Successfully imported Team %s - %d",team.getName(), team.getFanBase()));
                    }
                    sb.append(System.lineSeparator());
                });



        return sb.toString().trim();
    }

    @Override
    public Team findByTeamName(String name) {
        return this.teamRepository.findByName(name);
    }


}
