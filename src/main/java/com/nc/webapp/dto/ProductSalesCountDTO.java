package com.nc.webapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSalesCountDTO {
    private String productName;
    private int soldCount;
}
