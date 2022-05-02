package com.example.football.service.impl;

import com.example.football.models.dto.StatRootSeedDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidatorUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {

    public static final String STATS_FILE_PATH = "src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return this.statRepository.count() > 1;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        StatRootSeedDTO statRootSeedDTO = xmlParser.readFromFile(STATS_FILE_PATH, StatRootSeedDTO.class);

        statRootSeedDTO.getStats()
                .forEach(statSeedDTO -> {
                    if (!validatorUtil.isValid(statSeedDTO) || ( this.statRepository.findStatsByShootingAndPassingAndEndurance(statSeedDTO.getShooting(),statSeedDTO.getPassing(),statSeedDTO.getEndurance())!=null)) {
                        sb.append("Invalid stat");
                    } else {
                        this.statRepository.save(modelMapper.map(statSeedDTO, Stat.class));
                        sb.append(String.format("Successfully imported Stat %.2f - %.2f - %.2f",statSeedDTO.getShooting(),statSeedDTO.getPassing(),statSeedDTO.getEndurance()));
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    @Override
    public Stat findById(Long id) {
        return this.statRepository.findById(id).get();
    }
}
