package com.nc.webapp.dto;

import lombok.Data;

@Data
public class SaleDTO {
    private Integer idSale;
    private String saleDate;
    private String productAmount;
    private StoreDTO store;
    private BillOfSaleDTO billOfSale;
}
