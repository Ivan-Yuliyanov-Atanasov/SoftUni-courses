package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerImportDTO;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.service.TownService;
import exam.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {

    public static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final TownService townService;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, TownService townService) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 1;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {

        StringBuilder sb = new StringBuilder();

        CustomerImportDTO[] customers = gson.fromJson(new FileReader(CUSTOMERS_FILE_PATH), CustomerImportDTO[].class);

        Arrays.stream(customers).forEach(customer -> {
            if (!validatorUtil.isValid(customer) || (this.customerRepository.findByEmail(customer.getEmail()) != null)){
                sb.append("Invalid Customer");
            } else {
                Town town = townService.findByName(customer.getTown().getName());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate registeredOn = LocalDate.parse(customer.getRegisteredOn(), formatter);
                Customer currentCustomer = modelMapper.map(customer, Customer.class).setTown(town).setRegisteredOn(registeredOn);
                this.customerRepository.save(currentCustomer);
                sb.append(String.format("Successfully imported Customer %s %s - %s",currentCustomer.getFirstName(),currentCustomer.getLastName(),currentCustomer.getEmail()));

            }
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
