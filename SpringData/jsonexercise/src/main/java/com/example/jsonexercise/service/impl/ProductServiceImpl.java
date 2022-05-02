package com.example.jsonexercise.service.impl;

import com.example.jsonexercise.model.dto.ProductByNameAndPriceDto;
import com.example.jsonexercise.model.dto.ProductSeedDto;
import com.example.jsonexercise.model.entity.Product;
import com.example.jsonexercise.repository.ProductRepository;
import com.example.jsonexercise.service.CategoryService;
import com.example.jsonexercise.service.ProductService;
import com.example.jsonexercise.service.UserService;
import com.example.jsonexercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    public static final String PRODUCTS_FILE_PATH = "src/main/resources/files/products.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final ValidationUtil validationUtil;
    private final CategoryService categoryService;
    private final UserService userService;

    public ProductServiceImpl(Gson gson, ModelMapper modelMapper, ProductRepository productRepository, ValidationUtil validationUtil, CategoryService categoryService, UserService userService) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.validationUtil = validationUtil;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void seedProducts() throws IOException {

        if (productRepository.count() > 1){
            return;
        }
        AtomicInteger counter = new AtomicInteger(1);

        Arrays.stream(gson.fromJson(Files.readString(Path.of(PRODUCTS_FILE_PATH)), ProductSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(ProductSeedDto -> {
                    Product product = modelMapper.map(ProductSeedDto, Product.class);
                    product.setSeller(userService.findRandomUser());
                    if (counter.get() % 5 != 0) {
                        product.setBuyer(userService.findRandomUser());
                    }
                    product.setCategories(categoryService.randomCategories());
                    counter.getAndIncrement();
                    return product;
                })
                .forEach(productRepository::save);


    }

    @Override
    public List<ProductByNameAndPriceDto> findByPriceInRange(BigDecimal firstPrice, BigDecimal secondPrice) {
        return productRepository.findByPriceBetweenAndBuyerIsNullOrderByPrice(firstPrice, secondPrice)
                .stream().map(product -> {
                    ProductByNameAndPriceDto productByNameAndPriceDto = modelMapper.map(product, ProductByNameAndPriceDto.class);
                    String sellerFullName = (product.getSeller().getFirstName() == null ? "" :product.getSeller().getFirstName()+ " ") + product.getSeller().getLastName();
                    productByNameAndPriceDto.setSeller(sellerFullName);
                    return productByNameAndPriceDto;
                }).collect(Collectors.toList());


    }
}
