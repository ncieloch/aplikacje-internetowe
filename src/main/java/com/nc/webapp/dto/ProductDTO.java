package com.nc.webapp.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Integer idProduct;
    private String productName;
    private BigDecimal productPrice;
    private BrandDTO brand;
    private SectionDTO section;
}
