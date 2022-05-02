package com.example.jsoncardealer.service;

import com.example.jsoncardealer.model.dto.SaleInfoDto;

import java.util.List;

public interface SaleService {

    void seedSales();

    List<SaleInfoDto> getSaleFullInfo();
}
