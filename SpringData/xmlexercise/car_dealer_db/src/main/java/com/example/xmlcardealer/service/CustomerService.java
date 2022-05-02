package com.example.xmlcardealer.service;

import com.example.xmlcardealer.model.dto.export.CustomerSpentMoneyRootDto;
import com.example.xmlcardealer.model.dto.export.CustomerViewRootDto;
import com.example.xmlcardealer.model.dto.importData.CustomerSeedDto;
import com.example.xmlcardealer.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerSeedDto> customers);

    Customer findRandomCustomer();

    CustomerViewRootDto customersByBirthdate();

    CustomerSpentMoneyRootDto customersWithSales();
}
