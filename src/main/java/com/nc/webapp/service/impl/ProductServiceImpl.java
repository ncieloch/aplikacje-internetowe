package com.nc.webapp.service.impl;

import com.google.common.collect.Lists;
import com.nc.webapp.dto.ProductSalesCountDTO;
import com.nc.webapp.exception.AppRuntimeException;
import com.nc.webapp.exception.code.AppExceptionCode;
import com.nc.webapp.model.Product;
import com.nc.webapp.model.Sale;
import com.nc.webapp.repository.ProductRepository;
import com.nc.webapp.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createOrUpdate(Product product) {
        return saveEmployeeIfNotNull(product);
    }

    private Product saveEmployeeIfNotNull(Product product) throws AppRuntimeException {
        if (product == null) {
            throw new AppRuntimeException(AppExceptionCode.E003);
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.getOne(id);
    }

    @Override
    public List<ProductSalesCountDTO> getProductSalesCountReportData() {
        List<ProductSalesCountDTO> productSales = Lists.newArrayList();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            ProductSalesCountDTO productSalesCountDTO
                    = buildProductSalesCountDto(product.getProductName(), countSoldProducts(product));
            productSales.add(productSalesCountDTO);
        }
        productSales.sort(Comparator.comparing(ProductSalesCountDTO::getSoldCount).reversed());

        return productSales;
    }

    private int countSoldProducts(Product product) {
        int count = 0;
        for (Sale sale : product.getSales()) {
            String productAmount = sale.getProductAmount().replaceAll("\\s+","");
            count += Integer.parseInt(productAmount);
        }
        return count;
    }

    private ProductSalesCountDTO buildProductSalesCountDto(String productName, int count) {
        return ProductSalesCountDTO.builder()
                .productName(productName)
                .soldCount(count)
                .build();
    }

}
