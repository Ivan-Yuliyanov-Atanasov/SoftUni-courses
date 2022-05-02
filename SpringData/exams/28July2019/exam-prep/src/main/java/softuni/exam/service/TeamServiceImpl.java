package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.TeamSeedDto;
import softuni.exam.domain.dtos.TeamSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;


import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    public static final String TEAMS_FILE_PATH = "src/main/resources/files/xml/teams.xml";

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;
    private final PictureService pictureService;


    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser, PictureService pictureService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.pictureService = pictureService;
    }

    @Override

    public String importTeams() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        TeamSeedRootDto teamSeedRootDto = xmlParser.readFromFile(TEAMS_FILE_PATH, TeamSeedRootDto.class);
        teamSeedRootDto.getTeams().forEach(teamSeedDto -> {
            if (!validatorUtil.isValid(teamSeedDto)) {
                sb.append("Invalid team");
            } else {
                Team team = modelMapper.map(teamSeedDto, Team.class);

                Picture picture = pictureService.getPictureByUrl(team.getPicture().getUrl());
                if (picture == null) {
                    sb.append("Invalid team");
                } else {
                    team.setPicture(picture);
                    teamRepository.save(team);
                    sb.append(String.format("Successfully imported - %s", team.getName()));
                }

            }
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public Team getTeamByName(String name) {

        return teamRepository.findTeamByName(name).orElse(null);
    }

}
