package com.example.shop_db.service;

import com.example.shop_db.model.dto.ProductRootDto;
import com.example.shop_db.model.dto.ProductSeedDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(List<ProductSeedDto> products);

    ProductRootDto findByPriceInRange(BigDecimal firstPrice, BigDecimal secondPrice);
}
