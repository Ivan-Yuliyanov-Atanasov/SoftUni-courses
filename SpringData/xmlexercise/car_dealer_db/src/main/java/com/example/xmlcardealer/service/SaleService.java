package com.example.xmlcardealer.service;


import com.example.xmlcardealer.model.dto.export.SaleViewRootDto;

import java.util.List;

public interface SaleService {

    void seedSales();

    SaleViewRootDto getSaleFullInfo();


}
