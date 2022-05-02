package com.example.springintro.services;

import com.example.springintro.entities.Category;
import com.example.springintro.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {

        if (categoryRepository.count() > 0){
            return;
        }
        Files.readAllLines(Path.of("src/main/resources/files/categories.txt")).
                stream().filter(row -> !row.equals(""))
                .forEach(categoryName -> {
                    Category category = new Category(categoryName);
                    categoryRepository.save(category);
                });

    }

    @Override
    public Set<Category> getRandomCategories() {

        Set<Category> categories = new HashSet<>();
        int categoryCount = ThreadLocalRandom.current().nextInt(1,3);
        for (int i = 0; i < categoryCount; i++) {
            long id = ThreadLocalRandom.current().nextLong(1,categoryRepository.count() + 1);
            categories.add(categoryRepository.findById(id).orElse(null));

        }
        return categories;
    }
}
