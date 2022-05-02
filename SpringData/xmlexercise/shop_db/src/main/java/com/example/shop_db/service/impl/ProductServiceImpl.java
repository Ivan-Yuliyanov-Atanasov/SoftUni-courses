package com.example.shop_db.service.impl;

import com.example.shop_db.model.dto.ProductByNameAndPriceDto;
import com.example.shop_db.model.dto.ProductRootDto;
import com.example.shop_db.model.dto.ProductSeedDto;
import com.example.shop_db.model.entity.Product;
import com.example.shop_db.repository.ProductRepository;
import com.example.shop_db.service.CategoryService;
import com.example.shop_db.service.ProductService;
import com.example.shop_db.service.UserService;
import com.example.shop_db.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ValidationUtil validationUtil;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ValidationUtil validationUtil, CategoryService categoryService, UserService userService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.validationUtil = validationUtil;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {

        if (productRepository.count() > 1){
            return;
        }
        AtomicInteger counter = new AtomicInteger(1);
        products.stream().filter(validationUtil::isValid)
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
    public ProductRootDto findByPriceInRange(BigDecimal firstPrice, BigDecimal secondPrice) {
        ProductRootDto productRootDto = new ProductRootDto();
        productRootDto.setProducts(productRepository.findByPriceBetweenAndBuyerIsNullOrderByPrice(firstPrice, secondPrice)
                .stream().map(product -> {
                    ProductByNameAndPriceDto productByNameAndPriceDto = modelMapper.map(product, ProductByNameAndPriceDto.class);
                    String sellerFullName = (product.getSeller().getFirstName() == null ? "" :product.getSeller().getFirstName()+ " ") + product.getSeller().getLastName();
                    productByNameAndPriceDto.setSeller(sellerFullName);
                    return productByNameAndPriceDto;
                }).collect(Collectors.toList()));

        return productRootDto;
    }
}
