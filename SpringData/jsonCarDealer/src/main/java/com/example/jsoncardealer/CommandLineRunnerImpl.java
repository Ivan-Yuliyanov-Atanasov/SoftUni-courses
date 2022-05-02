package com.example.jsoncardealer;

import com.example.jsoncardealer.model.dto.*;
import com.example.jsoncardealer.service.*;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final static String OUTPUT_PATH = "src/main/resources/files/out/";
    private final static String CUSTOMERS_BIRTHDAY = "customers_by_birthdate.json";
    private final static String CARS_BY_MAKE = "cars_by_make.json";
    private final static String SUPPLIER_NOT_IMPORTER = "supplier_not_importer.json";
    private final static String CARS = "cars.json";
    private final static String SALES = "sales.json";
    private final static String CUSTOMER_WITH_SALES = "customers_with_sales.json";


    private final CustomerService customerService;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final SaleService saleService;
    private final BufferedReader reader;
    private final Gson gson;


    public CommandLineRunnerImpl(CustomerService customerService, SupplierService supplierService, PartService partService, CarService carService, SaleService saleService, Gson gson) {
        this.customerService = customerService;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.saleService = saleService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.gson = gson;
    }


    @Override
    public void run(String... args) throws Exception {

        seedData();
        selectExercise();

    }

    private void selectExercise() throws IOException {
        System.out.println("Please enter exercise number:");
        int exerciseNumber = Integer.parseInt(reader.readLine());

        switch (exerciseNumber) {

            case 1:
                List<CustomerViewDto> customers = customerService.customersByBirthdate();
                String contentExerOne = gson.toJson(customers);
                writeToFile(OUTPUT_PATH + CUSTOMERS_BIRTHDAY,contentExerOne);
                break;

            case 2:
                List<CarViewDto> carViewDtos = carService.carsByMake("Toyota");
                String contentExerTwo = gson.toJson(carViewDtos);
                writeToFile(OUTPUT_PATH + CARS_BY_MAKE, contentExerTwo);
                break;

            case 3:
                List<SupplierViewDto> supplierViewDtos = supplierService.suppliersThatDoNotImport();
                String contentExerThree = gson.toJson(supplierViewDtos);
                writeToFile(OUTPUT_PATH + SUPPLIER_NOT_IMPORTER, contentExerThree);
                break;
            case 4:
                List<CarWithPartsViewDto> carWithPartsViewDtos = carService.getAllCars();
                String contentExerFour = gson.toJson(carWithPartsViewDtos);
                writeToFile(OUTPUT_PATH + CARS, contentExerFour);
                break;

            case 5:
                List<CustomerSpentMoneyDto> customerSpentMoneyDtos = customerService.customersWithSales();
                String contentExerFive = gson.toJson(customerSpentMoneyDtos);
                writeToFile(OUTPUT_PATH + CUSTOMER_WITH_SALES, contentExerFive);
                break;
            case 6:

                List<SaleInfoDto> saleInfoDtos = saleService.getSaleFullInfo();
                String contentExerSix = gson.toJson(saleInfoDtos);
                writeToFile(OUTPUT_PATH + SALES, contentExerSix);
                break;


        }
    }

    private void seedData() throws IOException {
        supplierService.seedSuppliers();
        partService.seedParts();
        carService.seedCars();
        customerService.seedCustomers();
        saleService.seedSales();
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files.write(Path.of(filePath), Collections.singleton(content));
    }
}
