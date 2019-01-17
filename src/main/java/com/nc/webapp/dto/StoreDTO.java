package com.nc.webapp.dto;

import lombok.Data;

@Data
public class StoreDTO {
    private Integer idStore;
    private String storeAddress;
    private Double xPos;
    private Double yPos;
    private WarehouseDTO warehouse;
}
