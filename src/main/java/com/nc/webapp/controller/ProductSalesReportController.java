package com.nc.webapp.controller;

import com.nc.webapp.dto.ProductSalesCountDTO;
import com.nc.webapp.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-sales-report")
class ProductSalesReportController {

    private final ProductService productService;

    public ProductSalesReportController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductSalesCountDTO> getReport() {
        return productService.getProductSalesCountReportData();
    }

}
