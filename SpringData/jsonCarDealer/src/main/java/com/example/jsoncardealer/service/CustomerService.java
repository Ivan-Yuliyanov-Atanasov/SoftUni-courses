package com.example.jsoncardealer.service;

import com.example.jsoncardealer.model.dto.CustomerSpentMoneyDto;
import com.example.jsoncardealer.model.dto.CustomerViewDto;
import com.example.jsoncardealer.model.entity.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    void seedCustomers() throws IOException;

    Customer findRandomCustomer();

    List<CustomerViewDto> customersByBirthdate();

    List<CustomerSpentMoneyDto> customersWithSales();
}
