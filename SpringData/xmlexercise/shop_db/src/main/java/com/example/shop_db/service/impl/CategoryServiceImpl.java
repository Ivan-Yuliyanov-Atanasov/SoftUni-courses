package com.example.shop_db.service.impl;

import com.example.shop_db.model.dto.CategoryRootDto;
import com.example.shop_db.model.dto.CategorySeedDto;
import com.example.shop_db.model.dto.CategoryViewDto;
import com.example.shop_db.model.entity.Category;
import com.example.shop_db.model.entity.Product;
import com.example.shop_db.repository.CategoryRepository;
import com.example.shop_db.service.CategoryService;
import com.example.shop_db.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepository categoryRepository, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {

        if (categoryRepository.count() > 0) {
            return;
        }
        categories.stream().filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
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
    public CategoryRootDto categoryByProductsCount() {
        CategoryRootDto categoryRootDto = new CategoryRootDto();
        categoryRootDto.setCategories(categoryRepository.findByCountOfProducts().stream()
                .map(category -> {
                    int productsCount = category.getProducts().size();
                    List<BigDecimal> productPrices = category.getProducts().stream().map(Product::getPrice).collect(Collectors.toList());
                    BigDecimal sum = BigDecimal.ZERO;
                    for (BigDecimal amt : productPrices) {
                        sum = sum.add(amt);
                    }
                    BigDecimal average = sum.divide(BigDecimal.valueOf(productPrices.size()), 6, RoundingMode.HALF_EVEN);
                    CategoryViewDto categoryViewDto = new CategoryViewDto();
                    categoryViewDto.setName(category.getName());
                    categoryViewDto.setProductsCount(productsCount);
                    categoryViewDto.setAveragePrice(average);
                    categoryViewDto.setTotalRevenue(sum);
                    return categoryViewDto;
                }).collect(Collectors.toList()));


        return categoryRootDto;
    }
}
