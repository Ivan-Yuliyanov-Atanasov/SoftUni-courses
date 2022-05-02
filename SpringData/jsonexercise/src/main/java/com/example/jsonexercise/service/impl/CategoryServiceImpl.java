package com.example.jsonexercise.service.impl;

import com.example.jsonexercise.model.dto.CategorySeedDto;
import com.example.jsonexercise.model.dto.CategoryViewDto;
import com.example.jsonexercise.model.entity.Category;
import com.example.jsonexercise.model.entity.Product;
import com.example.jsonexercise.repository.CategoryRepository;
import com.example.jsonexercise.service.CategoryService;
import com.example.jsonexercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    public static final String CATEGORIES_FILE_PATH = "src/main/resources/files/categories.json";
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(Gson gson, ModelMapper modelMapper, CategoryRepository categoryRepository, ValidationUtil validationUtil) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories() throws IOException {

        if (categoryRepository.count() > 0) {
            return;
        }

        String categoryFileContent = Files.readString(Path.of(CATEGORIES_FILE_PATH));

        CategorySeedDto[] categorySeedDtos = gson.fromJson(categoryFileContent, CategorySeedDto[].class);
        Arrays.stream(categorySeedDtos).filter(validationUtil::isValid).
                map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);

    }

    @Override
    public Set<Category> randomCategories() {
        int randomCountOfCategories = ThreadLocalRandom.current().nextInt(1 ,4);
        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < randomCountOfCategories; i++) {
            long randomCategoryId = ThreadLocalRandom.current().nextLong(1, categoryRepository.count() + 1);
            categories.add(categoryRepository.findById(randomCategoryId).orElse(null));
        }
        return categories;
    }

    @Override
    public List<CategoryViewDto> categoryByProductsCount() {
        return categoryRepository.findByCountOfProducts().stream()
                .map(category -> {
                    int productsCount = category.getProducts().size();
                    List<BigDecimal> productPrices = category.getProducts().stream().map(Product::getPrice).collect(Collectors.toList());
                    BigDecimal sum = BigDecimal.ZERO;
                    for (BigDecimal amt : productPrices) {
                        sum = sum.add(amt);
                    }
                    BigDecimal average = sum.divide(BigDecimal.valueOf(productPrices.size()), 6, RoundingMode.HALF_EVEN);
                    CategoryViewDto categoryViewDto = new CategoryViewDto();
                    categoryViewDto.setCategory(category.getName());
                    categoryViewDto.setProductsCount(productsCount);
                    categoryViewDto.setAveragePrice(average);
                    categoryViewDto.setTotalRevenue(sum);
                    return categoryViewDto;
                }).collect(Collectors.toList());
    }
}
