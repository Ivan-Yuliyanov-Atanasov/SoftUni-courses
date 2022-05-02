package com.example.xmlcardealer;

import com.example.xmlcardealer.model.dto.export.*;
import com.example.xmlcardealer.model.dto.importData.CarSeedRootDto;
import com.example.xmlcardealer.model.dto.importData.CustomerSeedRootDto;
import com.example.xmlcardealer.model.dto.importData.PartSeedRootDto;
import com.example.xmlcardealer.model.dto.importData.SupplierSeedRootDto;
import com.example.xmlcardealer.service.*;
import com.example.xmlcardealer.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final XmlParser xmlParser;
    private final BufferedReader reader;
    private static final String SUPPLIERS_FILE_PATH = "src/main/resources/files/suppliers.xml";
    private static final String PARTS_FILE_PATH = "src/main/resources/files/parts.xml";
    private static final String CARS_FILE_PATH = "src/main/resources/files/cars.xml";
    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/customers.xml";
    private final static String OUTPUT_PATH = "src/main/resources/files/out/";
    private final static String CUSTOMERS_BIRTHDAY = "customers_by_birthdate.xml";
    private final static String CARS_BY_MAKE = "cars_by_make.xml";
    private final static String SUPPLIER_NOT_IMPORTER = "supplier_not_importer.xml";
    private final static String CARS = "cars.xml";
    private final static String SALES = "sales.xml";
    private final static String CUSTOMER_WITH_SALES = "customers_with_sales.xml";


    public CommandLineRunnerImpl(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, XmlParser xmlParser) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.xmlParser = xmlParser;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();
        selectExercise();

    }

    private void selectExercise() throws IOException, JAXBException {
        System.out.println("Please enter exercise number:");
        int exerciseNumber = Integer.parseInt(reader.readLine());

        switch (exerciseNumber) {

            case 1:
                CustomerViewRootDto customer = customerService.customersByBirthdate();
                xmlParser.writeToFile(OUTPUT_PATH + CUSTOMERS_BIRTHDAY, customer);

                break;

            case 2:
                CarViewRootDto cars = carService.carsByMake("Toyota");
                xmlParser.writeToFile(OUTPUT_PATH + CARS_BY_MAKE, cars);
                break;

            case 3:
                SupplierViewRootDto suppliers = supplierService.suppliersThatDoNotImport();
                xmlParser.writeToFile(OUTPUT_PATH + SUPPLIER_NOT_IMPORTER, suppliers);
                break;

            case 4:
                CarInfoRootDto carsDtos = carService.getAllCars();
                xmlParser.writeToFile(OUTPUT_PATH + CARS, carsDtos);

            case 5:
                CustomerSpentMoneyRootDto customerDto = customerService.customersWithSales();
                xmlParser.writeToFile(OUTPUT_PATH + CUSTOMER_WITH_SALES, customerDto);
                break;

            case 6:
                SaleViewRootDto sales = saleService.getSaleFullInfo();
                xmlParser.writeToFile(OUTPUT_PATH + SALES, sales);
                break;


        }
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        SupplierSeedRootDto supplierSeedRootDto = xmlParser.readFromFile(SUPPLIERS_FILE_PATH, SupplierSeedRootDto.class);
        supplierService.seedSuppliers(supplierSeedRootDto.getSuppliers());

        PartSeedRootDto partSeedRootDto = xmlParser.readFromFile(PARTS_FILE_PATH, PartSeedRootDto.class);
        partService.seedParts(partSeedRootDto.getParts());

        CarSeedRootDto carSeedRootDto = xmlParser.readFromFile(CARS_FILE_PATH, CarSeedRootDto.class);
        carService.seedCars(carSeedRootDto.getCars());

        CustomerSeedRootDto customerSeedRootDto = xmlParser.readFromFile(CUSTOMERS_FILE_PATH, CustomerSeedRootDto.class);
        customerService.seedCustomers(customerSeedRootDto.getCustomers());

        saleService.seedSales();
    }
}
