package com.nc.webapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillOfSaleReportDTO {
    private String month;
    private int soldCount;
}
