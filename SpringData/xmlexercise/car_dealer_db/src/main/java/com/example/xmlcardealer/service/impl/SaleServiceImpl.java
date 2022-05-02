package com.example.xmlcardealer.service.impl;



import com.example.xmlcardealer.model.dto.export.SaleViewDto;
import com.example.xmlcardealer.model.dto.export.SaleViewRootDto;
import com.example.xmlcardealer.model.entity.Car;
import com.example.xmlcardealer.model.entity.Customer;
import com.example.xmlcardealer.model.entity.Sale;
import com.example.xmlcardealer.repository.SalesRepository;
import com.example.xmlcardealer.service.CarService;
import com.example.xmlcardealer.service.CustomerService;
import com.example.xmlcardealer.service.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private final SalesRepository salesRepository;
    private final CustomerService customerService;
    private final CarService carService;
    private final ModelMapper modelMapper;
    private static final int [] DISCOUNT_PERCENTAGES = {0, 5, 10, 15, 20, 30, 40, 50};

    public SaleServiceImpl(SalesRepository salesRepository, CustomerService customerService, CarService carService, ModelMapper modelMapper) {
        this.salesRepository = salesRepository;
        this.customerService = customerService;
        this.carService = carService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedSales() {

        if (salesRepository.count() > 0) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            Sale sale  = new Sale();
            int randomDiscountPercentage = DISCOUNT_PERCENTAGES[ThreadLocalRandom.current().nextInt(0, DISCOUNT_PERCENTAGES.length)];
            Customer customer = customerService.findRandomCustomer();
            if (customer.isYoungDriver()) {
                randomDiscountPercentage += 5;
            }
            Car car = carService.findRandomCar();
            sale.setCar(car).setCustomer(customer).setDiscount(randomDiscountPercentage);
            salesRepository.save(sale);
        }
    }

    @Override
    public SaleViewRootDto getSaleFullInfo() {
        List<SaleViewDto> sales =  salesRepository.findAll().stream()
                .map(sale -> {
                    SaleViewDto saleInfoDto =  modelMapper.map(sale, SaleViewDto.class);
                    BigDecimal price = sale.getCar().totalPrice();
                    BigDecimal discountPercentage = new BigDecimal(Double.toString((double)sale.getDiscount() / 100));
                    BigDecimal discountAmount = price.multiply(discountPercentage);
                    BigDecimal priceWithDiscount = price.subtract(discountAmount);
                    saleInfoDto.setCustomerName(sale.getCustomer().getName())
                            .setPrice(price)
                            .setDiscount((double)sale.getDiscount() / 100)
                            .setPriceWithDiscount(priceWithDiscount);
                    return saleInfoDto;
                }).collect(Collectors.toList());

        return new SaleViewRootDto().setSales(sales);

    }


}
