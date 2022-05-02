package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneRootImportDTO;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class PlaneServiceImpl implements PlaneService {

    public static final String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;

    public PlaneServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, PlaneRepository planeRepository, XmlParser xmlParser) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 1;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        PlaneRootImportDTO planeRootImportDTO = xmlParser.readFromFile(PLANES_FILE_PATH, PlaneRootImportDTO.class);

        planeRootImportDTO.getPlanes().forEach(planeImportDTO -> {
            if(!validationUtil.isValid(planeImportDTO)){
                sb.append("Invalid Plane");
            } else {
                this.planeRepository.save(modelMapper.map(planeImportDTO, Plane.class));
                sb.append(String.format("Successfully imported Plane %s", planeImportDTO.getRegisterNumber()));
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    @Override
    public Plane findPlaneByRegisterNumber(String registerNumber) {
        return this.planeRepository.findByRegisterNumber(registerNumber);
    }
}
