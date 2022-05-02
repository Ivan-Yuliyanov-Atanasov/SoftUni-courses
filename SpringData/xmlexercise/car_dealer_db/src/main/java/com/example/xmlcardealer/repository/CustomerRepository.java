package com.example.xmlcardealer.repository;


import com.example.xmlcardealer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> getAllByOrderByBirthDateAscIsYoungDriverAsc();

    @Query("SELECT c from Customer c WHere size(c.sales) >= 1")
    List<Customer> getAllCustomersWithSales();
}
