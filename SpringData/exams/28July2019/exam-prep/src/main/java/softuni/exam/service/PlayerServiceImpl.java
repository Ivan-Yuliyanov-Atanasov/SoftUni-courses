package softuni.exam.service;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PlayerSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.domain.entities.enums.PositionEnum;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidatorUtil;


import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    public static final String PLAYERS_FILE_PATH = "src/main/resources/files/json/players.json";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final TeamService teamService;
    private final PictureService pictureService;


    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, TeamService teamService, PictureService pictureService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.teamService = teamService;
        this.pictureService = pictureService;
    }


    @Override
    public String importPlayers() throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        PlayerSeedDto[] playerSeedDtos = gson.fromJson(new FileReader(PLAYERS_FILE_PATH), PlayerSeedDto[].class);

        Arrays.stream(playerSeedDtos).forEach(playerSeedDto -> {
            if (!validatorUtil.isValid(playerSeedDto)) {
                sb.append("Invalid player");
            } else {
                Team team = teamService.getTeamByName(playerSeedDto.getTeam().getName());
                if (team == null) {
                    sb.append("Invalid player");
                }
                Picture picture = pictureService.getPictureByUrl(playerSeedDto.getPicture().getUrl());
                if (picture == null) {
                    sb.append("Invalid player");
                }
                playerRepository.save(modelMapper.map(playerSeedDto, Player.class).setPicture(picture).setTeam(team));
                sb.append(String.format("Successfully imported player: %s %s", playerSeedDto.getFirstName(), playerSeedDto.getLastName()));


            }
            sb.append(System.lineSeparator());
        });



        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {

        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();

        List<Player> playersBySalary = playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(new BigDecimal("100000"));
        playersBySalary.forEach(player -> sb.append(String.format("Player name: %s %s\n" +
                "Number: %s\n" +
                "Salary: %s\n" +
                "Team: %s",player.getFirstName(),player.getLastName(),player.getNumber(),player.getSalary(),player.getTeam().getName())).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {

        StringBuilder sb = new StringBuilder();
        sb.append("Team: North Hub").append(System.lineSeparator());
        List<Player> playerByTeam = playerRepository.findAllByTeamNameOrderById("North Hub");
        playerByTeam.forEach(player -> sb.append(String.format("\tPlayer name: %s %s - %s\n" +
                "\tNumber: %s",player.getFirstName(),player.getLastName(),player.getPosition(),player.getNumber())).append(System.lineSeparator()));
        System.out.println();
        return sb.toString().trim();
    }


}
