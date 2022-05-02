package com.example.jsonexercise.service;

import com.example.jsonexercise.model.dto.ProductByNameAndPriceDto;
import com.example.jsonexercise.model.dto.ProductSeedDto;
import com.example.jsonexercise.model.entity.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductByNameAndPriceDto> findByPriceInRange(BigDecimal firstPrice, BigDecimal secondPrice);
}
