package com.nc.webapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreSaleReportDTO {
    private String storeAddress;
    private int soldCount;
}
