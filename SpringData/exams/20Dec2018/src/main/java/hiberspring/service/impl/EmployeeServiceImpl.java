package hiberspring.service.impl;

import hiberspring.domain.dtos.EmployeeImportRootDTO;
import hiberspring.domain.dtos.ProductImportRootDTO;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.entities.Product;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeCardService;
import hiberspring.service.EmployeeService;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String EMPLOYEES_FILE_PATH = "src/main/resources/files/employees.xml";

    private final FileUtil fileUtil;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;
    private final EmployeeRepository employeeRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public EmployeeServiceImpl(FileUtil fileUtil, BranchService branchService, EmployeeCardService employeeCardService, EmployeeRepository employeeRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.fileUtil = fileUtil;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
        this.employeeRepository = employeeRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return fileUtil.readFile(EMPLOYEES_FILE_PATH);
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        EmployeeImportRootDTO employees = xmlParser.parseXml(EmployeeImportRootDTO.class, EMPLOYEES_FILE_PATH);

        employees.getEmployees()
                .forEach(employeeImportDTO -> {
                    if (!validationUtil.isValid(employeeImportDTO)) {
                        sb.append("Error: Invalid data.");

                    } else {

                        EmployeeCard employeeCard = this.employeeCardService.findEmployeeCardByNumber(employeeImportDTO.getCard());
                        Branch branch = this.branchService.findBranchByName(employeeImportDTO.getBranch());
                        boolean hasSameEmployeeCard = this.employeeRepository.findAll().stream().anyMatch(e -> e.getEmployeeCard().getNumber().equals(employeeCard.getNumber()));
                        if(employeeCard != null && branch != null && !hasSameEmployeeCard) {
                            this.employeeRepository.save(modelMapper.map(employeeImportDTO, Employee.class).setBranch(branch).setEmployeeCard(employeeCard));
                            sb.append(String.format("Successfully imported Employee %s %s.",employeeImportDTO.getFirstName(), employeeImportDTO.getLastName()));

                        } else {
                            sb.append("Error: Invalid data.");
                        }


                    }

                    sb.append(System.lineSeparator());
                });


        return sb.toString().trim();
    }

    @Override
    public String exportProductiveEmployees() {

        StringBuilder sb = new StringBuilder();
        this.employeeRepository.exportEmployees().forEach(e-> sb.append(e.toString()));
        return sb.toString().trim();
    }
}
