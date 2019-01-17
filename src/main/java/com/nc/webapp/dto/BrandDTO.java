package com.nc.webapp.dto;

import lombok.Data;

@Data
public class BrandDTO {
    private Integer idBrand;
    private String brandName;
    private ManufacturerDTO manufacturer;
}
