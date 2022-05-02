package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.TownImportDTO;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {


    private static final String TOWNS_FILE_PATH = "src/main/resources/files/towns.json";
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return fileUtil.readFile(TOWNS_FILE_PATH);
    }

    @Override
    public String importTowns(String townsFileContent) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TownImportDTO[] towns = gson.fromJson(new FileReader(TOWNS_FILE_PATH), TownImportDTO[].class);

        Arrays.stream(towns)
                .forEach(townImportDTO -> {
                    if (!validationUtil.isValid(townImportDTO)) {
                        sb.append("Error: Invalid data.");

                    } else {

                        this.townRepository.save(modelMapper.map(townImportDTO, Town.class));
                        sb.append(String.format("Successfully imported Town %s.",townImportDTO.getName()));


                    }

                    sb.append(System.lineSeparator());
                });


        return sb.toString().trim();
    }

    @Override
    public Town findTownByName(String name) {
        return this.townRepository.findByName(name).orElse(null);
    }
}
