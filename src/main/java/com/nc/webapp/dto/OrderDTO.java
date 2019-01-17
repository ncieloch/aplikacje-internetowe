package com.nc.webapp.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderDTO {
    private Integer idOrder;
    private Integer productAmount;
    private Date orderDate;
    private Date predictedDeliveryDate;
    private SupplierDTO supplier;
    private WarehouseDTO warehouse;
}
