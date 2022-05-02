package com.example.shop_db.repository;

import com.example.shop_db.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal firstPrice, BigDecimal secondPrice);
}
