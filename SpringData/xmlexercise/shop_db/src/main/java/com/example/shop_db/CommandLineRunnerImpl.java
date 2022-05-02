package com.example.shop_db;

import com.example.shop_db.model.dto.*;
import com.example.shop_db.model.dto.task4.UserSoldProductsRootDtoTask4;
import com.example.shop_db.service.CategoryService;
import com.example.shop_db.service.ProductService;
import com.example.shop_db.service.UserService;
import com.example.shop_db.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final XmlParser xmlParser;
    private final BufferedReader reader;
    private static final String CATEGORY_FILE_PATH = "src/main/resources/files/categories.xml";
    private static final String USER_FILE_PATH = "src/main/resources/files/users.xml";
    private static final String PRODUCT_FILE_PATH = "src/main/resources/files/products.xml";
    private final static String OUTPUT_PATH = "src/main/resources/files/out/";
    private final static String PRODUCTS_IN_RANGE = "products-in-range.xml";
    public static final String SELLER_INFO = "seller-products.xml";
    public static final String CATEGORY_INFO = "category-products.xml";
    public static final String USER_INFO = "user-products.xml";

    public CommandLineRunnerImpl(UserService userService, ProductService productService, CategoryService categoryService, XmlParser xmlParser) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
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
                System.out.println("Please enter first price:");
                BigDecimal firstPrice = new BigDecimal(reader.readLine());
                System.out.println("Please enter second price:");
                BigDecimal secondPrice = new BigDecimal(reader.readLine());
                ProductRootDto productRootDto = productService.findByPriceInRange(firstPrice, secondPrice);
                xmlParser.writeToFile(OUTPUT_PATH + PRODUCTS_IN_RANGE, productRootDto);

                break;

            case 2:
                UserSoldProductsRootDto userSoldDto = userService.findAllUsersWithAtLeastOneProductSold();

                xmlParser.writeToFile(OUTPUT_PATH + SELLER_INFO, userSoldDto);
                break;

            case 3:
                CategoryRootDto categoryRootDto = categoryService.categoryByProductsCount();

                xmlParser.writeToFile(OUTPUT_PATH + CATEGORY_INFO, categoryRootDto);
                break;

            case 4:
                UserSoldProductsRootDtoTask4 userSoldProductsRootDtoTask4 = userService.usersWithAtLeastOneSoldProductOrderedBySellsCount();

                xmlParser.writeToFile(OUTPUT_PATH + USER_INFO, userSoldProductsRootDtoTask4);
                break;


        }
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        CategorySeedRootDto categorySeedRootDto = xmlParser.readFromFile(CATEGORY_FILE_PATH, CategorySeedRootDto.class);
        categoryService.seedCategories(categorySeedRootDto.getCategories());

        UserSeedRootDto userSeedRootDto = xmlParser.readFromFile(USER_FILE_PATH, UserSeedRootDto.class);
        userService.seedUsers(userSeedRootDto.getUsers());

        ProductSeedRootDto productSeedRootDto = xmlParser.readFromFile(PRODUCT_FILE_PATH, ProductSeedRootDto.class);
        productService.seedProducts(productSeedRootDto.getProducts());
    }

}
