package com.nc.webapp.service;

import com.nc.webapp.dto.BillOfSaleReportDTO;

import java.util.List;

public interface BillOfSaleService {
    List<BillOfSaleReportDTO> getBillOfSaleReport();
}
