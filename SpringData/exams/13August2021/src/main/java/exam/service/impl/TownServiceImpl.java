package exam.service.impl;

import exam.model.dto.TownRootImportDTO;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidatorUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    public static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
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
    public String importTowns() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        TownRootImportDTO townRootImportDTO = xmlParser.readFromFile(TOWNS_FILE_PATH, TownRootImportDTO.class);

        townRootImportDTO.getTowns()
                .forEach(townImportDTO -> {
                    if(!validatorUtil.isValid(townImportDTO)) {
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
    public Town findByName(String name) {
        return this.townRepository.findByName(name);
    }
}
