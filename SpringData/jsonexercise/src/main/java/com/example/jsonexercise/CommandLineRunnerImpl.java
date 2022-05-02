package com.example.jsonexercise;

import com.example.jsonexercise.model.dto.CategoryViewDto;
import com.example.jsonexercise.model.dto.ProductByNameAndPriceDto;
import com.example.jsonexercise.model.dto.SellerDto;
import com.example.jsonexercise.model.dto.UserCountDto;
import com.example.jsonexercise.service.CategoryService;
import com.example.jsonexercise.service.ProductService;
import com.example.jsonexercise.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final static String OUTPUT_PATH = "src/main/resources/files/out/";
    private final static String PRODUCTS_IN_RANGE = "products-in-range.json";
    public static final String SELLER_INFO = "seller-products.json";
    public static final String CATEGORY_INFO = "category-products.json";
    public static final String USER_INFO = "user-products.json";
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader reader;
    private final Gson gson;

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
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
                System.out.println("Please enter first price:");
                BigDecimal firstPrice = new BigDecimal(reader.readLine());
                System.out.println("Please enter second price:");
                BigDecimal secondPrice = new BigDecimal(reader.readLine());
                List<ProductByNameAndPriceDto> byPriceInRange = productService.findByPriceInRange(firstPrice, secondPrice);
                String content = gson.toJson(byPriceInRange);
                
                writeToFile(OUTPUT_PATH + PRODUCTS_IN_RANGE, content);

                break;

            case 2:
                List<SellerDto> sellerDtos = userService.findAllUsersWithAtLeastOneProductSold();
                String contentExerTwo = gson.toJson(sellerDtos);
                writeToFile(OUTPUT_PATH + SELLER_INFO, contentExerTwo);
                break;

            case 3:
                List<CategoryViewDto> categoryViewDtos = categoryService.categoryByProductsCount();
                String contentExerThree = gson.toJson(categoryViewDtos);
                writeToFile(OUTPUT_PATH + CATEGORY_INFO, contentExerThree);
                break;

            case 4:
                UserCountDto users = userService.usersWithAtLeastOneSoldProductOrderedBySellsCount();
                String contentExerFour = gson.toJson(users);
                writeToFile(OUTPUT_PATH + USER_INFO, contentExerFour);
                break;


        }
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files.write(Path.of(filePath), Collections.singleton(content));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();

    }
}
