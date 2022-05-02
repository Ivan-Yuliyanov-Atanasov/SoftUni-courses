package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.EmployeeCardImportDTO;
import hiberspring.domain.dtos.TownImportDTO;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.entities.Town;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private static final String CARDS_FILE_PATH = "src/main/resources/files/employee-cards.json";
    private final EmployeeCardRepository employeeCardRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;

    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil) {
        this.employeeCardRepository = employeeCardRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return this.fileUtil.readFile(CARDS_FILE_PATH);
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws IOException {

        StringBuilder sb = new StringBuilder();
        EmployeeCardImportDTO[] employeeCards = gson.fromJson(readEmployeeCardsJsonFile(), EmployeeCardImportDTO[].class);

        Arrays.stream(employeeCards)
                .forEach(employeeCardImportDTO -> {
                    if (!validationUtil.isValid(employeeCardImportDTO)) {
                        sb.append("Error: Invalid data.");

                    } else {
                        if(findEmployeeCardByNumber(employeeCardImportDTO.getNumber()) == null) {
                            this.employeeCardRepository.save(modelMapper.map(employeeCardImportDTO, EmployeeCard.class));
                            sb.append(String.format("Successfully imported Employee Card %s.",employeeCardImportDTO.getNumber()));
                        } else {
                            sb.append(String.format("Employee Card %s already in the database.",employeeCardImportDTO.getNumber()));
                        }

                    }

                    sb.append(System.lineSeparator());
                });


        return sb.toString().trim();
    }

    @Override
    public EmployeeCard findEmployeeCardByNumber(String number) {
        return this.employeeCardRepository.findByNumber(number).orElse(null);
    }
}
