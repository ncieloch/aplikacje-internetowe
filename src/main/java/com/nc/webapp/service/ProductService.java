package com.nc.webapp.service;

import com.nc.webapp.dto.ProductSalesCountDTO;
import com.nc.webapp.model.Product;

import java.util.List;

public interface ProductService {
    Product createOrUpdate(Product product);
    List<Product> getAll();
    Product getById(Integer id);
    List<ProductSalesCountDTO> getProductSalesCountReportData();
}
