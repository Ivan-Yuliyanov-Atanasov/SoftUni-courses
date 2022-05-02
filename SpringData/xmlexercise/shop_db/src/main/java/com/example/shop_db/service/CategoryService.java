package com.example.shop_db.service;

import com.example.shop_db.model.dto.CategoryRootDto;
import com.example.shop_db.model.dto.CategorySeedDto;
import com.example.shop_db.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);

    Set<Category> randomCategories();

    CategoryRootDto categoryByProductsCount();
}
