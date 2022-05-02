package com.example.football.service.impl;

import com.example.football.models.dto.PlayerRootSeedDto;
import com.example.football.models.dto.PlayerSeedDto;
import com.example.football.models.dto.StatRootSeedDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidatorUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PlayerServiceImpl implements PlayerService {

    public static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;
    private final TeamService teamService;
    private final StatService statService;
    private final TownService townService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser, TeamService teamService, StatService statService, TownService townService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.teamService = teamService;
        this.statService = statService;
        this.townService = townService;
    }


    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 1;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        PlayerRootSeedDto playerRootSeedDto = xmlParser.readFromFile(PLAYERS_FILE_PATH, PlayerRootSeedDto.class);

        playerRootSeedDto.getPlayers().forEach(playerSeedDto -> {
            if (!validatorUtil.isValid(playerSeedDto) || (this.playerRepository.findByEmail(playerSeedDto.getEmail()) != null)) {
                sb.append("Invalid Player");
            } else {
                Town town = townService.findTownByName(playerSeedDto.getTown().getName());
                Team team = teamService.findByTeamName(playerSeedDto.getTeam().getName());
                Stat stat = statService.findById(playerSeedDto.getStat().getId());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate birthDate = LocalDate.parse(playerSeedDto.getBirthDate(), formatter);
                Player player = modelMapper.map(playerSeedDto, Player.class)
                        .setBirthDate(birthDate)
                        .setTown(town)
                        .setStat(stat)
                        .setTeam(team);
                this.playerRepository.save(player);
                sb.append(String.format("Successfully imported Player %s %s - %s",player.getFirstName(),player.getLastName(), playerSeedDto.getPosition()));
            }

            sb.append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {

        StringBuilder sb = new StringBuilder();

        LocalDate after = LocalDate.parse("1995-01-01");
        LocalDate before = LocalDate.parse("2003-01-01");

        this.playerRepository.bestPlayers(after, before)
                .forEach(player -> {
                    sb.append(String.format("\"Player - %s %s\n" +
                            "\t Position - %s\n" +
                            "\t Team - %s\n" +
                            "\t Stadium - %s",player.getFirstName(), player.getLastName(), player.getPosition().name(),player.getTeam().getName(),player.getTeam().getStadiumName())).append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
}
