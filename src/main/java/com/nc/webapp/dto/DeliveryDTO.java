package com.nc.webapp.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class DeliveryDTO {
    private Integer idDelivery;
    private Integer productAmount;
    private Date deliveryDate;
    private Date datePOrder;
    private ProductDTO product;
    private SupplierDTO supplier;
}
