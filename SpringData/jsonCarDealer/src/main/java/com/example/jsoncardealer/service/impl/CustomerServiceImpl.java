package com.example.jsoncardealer.service.impl;

import com.example.jsoncardealer.model.dto.CustomerSeedDto;
import com.example.jsoncardealer.model.dto.CustomerSpentMoneyDto;
import com.example.jsoncardealer.model.dto.CustomerViewDto;
import com.example.jsoncardealer.model.dto.SaleViewDto;
import com.example.jsoncardealer.model.entity.Customer;

import com.example.jsoncardealer.model.entity.Sale;
import com.example.jsoncardealer.repository.CustomerRepository;
import com.example.jsoncardealer.service.CustomerService;
import com.example.jsoncardealer.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    public static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/customers.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedCustomers() throws IOException {

        if (customerRepository.count() > 0) {
            return;
        }

        String categoryFileContent = Files.readString(Path.of(CUSTOMERS_FILE_PATH));

        CustomerSeedDto[] customerSeedDtos = gson.fromJson(categoryFileContent, CustomerSeedDto[].class);
        Arrays.stream(customerSeedDtos).filter(validationUtil::isValid).
                map(customerSeedDto -> {
                    Customer customer = modelMapper.map(customerSeedDto, Customer.class);
                    customer.setBirthDate(LocalDateTime.parse(customerSeedDto.getBirthDate()));
                    return customer;
                })
                .forEach(customerRepository::save);

    }

    @Override
    public Customer findRandomCustomer() {
        long randomId = ThreadLocalRandom.current().nextLong(1, customerRepository.count() + 1);
        return customerRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<CustomerViewDto> customersByBirthdate() {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        return customerRepository.getAllByOrderByBirthDateAscIsYoungDriverAsc().stream()
                .map(customer -> {
                    CustomerViewDto customerViewDto = modelMapper.map(customer, CustomerViewDto.class);
                    customerViewDto.setBirthDate(customer.getBirthDate().format(formatter));

                    Set<SaleViewDto> salesDto = customer.getSales().stream()
                            .map(sale -> {
                                SaleViewDto saleDto = modelMapper.map(sale, SaleViewDto.class);
                                saleDto.setCarModel(sale.getCar().getModel());
                                saleDto.setCarMake(sale.getCar().getMake());
                                return saleDto;
                            }).
                            collect(Collectors.toSet());

                    customerViewDto.setSales(salesDto);

                    return customerViewDto;


                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerSpentMoneyDto> customersWithSales() {
        return customerRepository.getAllCustomersWithSales().stream()

                .map(customer -> {
                    BigDecimal totalSpentMoney = new BigDecimal("0");
                    for (Sale sale : customer.getSales()) {
                        totalSpentMoney = totalSpentMoney.add(sale.getCar().totalPrice());

                    }
                    int boughtCars = customer.getSales().size();
                    CustomerSpentMoneyDto customerSpentMoneyDto = new CustomerSpentMoneyDto();
                    customerSpentMoneyDto.setFullName(customer.getName())
                            .setBoughtCars(boughtCars)
                            .setSpentMoney(totalSpentMoney);
                    return customerSpentMoneyDto;
                }).
                sorted((c1, c2) -> {
                    int result = c2.getSpentMoney().compareTo(c1.getSpentMoney());
                    if (result == 0) {
                        result = Integer.compare(c2.getBoughtCars(), c1.getBoughtCars());
                    }
                    return result;
                }).collect(Collectors.toList());
    }

}

