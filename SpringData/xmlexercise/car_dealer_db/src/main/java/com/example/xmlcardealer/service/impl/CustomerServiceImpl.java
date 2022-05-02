package com.example.xmlcardealer.service.impl;

import com.example.xmlcardealer.model.dto.export.CustomerSpentMoneyDto;
import com.example.xmlcardealer.model.dto.export.CustomerSpentMoneyRootDto;
import com.example.xmlcardealer.model.dto.export.CustomerViewDto;
import com.example.xmlcardealer.model.dto.export.CustomerViewRootDto;
import com.example.xmlcardealer.model.dto.importData.CustomerSeedDto;
import com.example.xmlcardealer.model.entity.Customer;
import com.example.xmlcardealer.model.entity.Sale;
import com.example.xmlcardealer.repository.CustomerRepository;
import com.example.xmlcardealer.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedCustomers(List<CustomerSeedDto> customers) {

        if (customerRepository.count() > 0) {
            return;
        }

        customers
                .stream()
                .map(customerSeedDto -> {
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
    public CustomerViewRootDto customersByBirthdate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        List<CustomerViewDto> customers = customerRepository.getAllByOrderByBirthDateAscIsYoungDriverAsc()
                .stream()
                .map(customer -> {
                    CustomerViewDto customerViewDto = modelMapper.map(customer, CustomerViewDto.class);
                    customerViewDto.setBirthDate(customer.getBirthDate().format(formatter));
                    return customerViewDto;
                }).collect(Collectors.toList());
        return new CustomerViewRootDto().setCustomers(customers);

    }

    @Override
    public CustomerSpentMoneyRootDto customersWithSales() {
        List<CustomerSpentMoneyDto> customerSpentMoneyDtos = customerRepository.getAllCustomersWithSales().stream()

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

        return new CustomerSpentMoneyRootDto().setCustomers(customerSpentMoneyDtos);
    }

}
