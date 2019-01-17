package com.nc.webapp.controller;

import com.nc.webapp.dto.BillOfSaleReportDTO;
import com.nc.webapp.service.BillOfSaleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bill-of-sale-reports")
class BillOfSaleReportController {

    private final BillOfSaleService billOfSaleService;

    public BillOfSaleReportController(BillOfSaleService billOfSaleService) {
        this.billOfSaleService = billOfSaleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BillOfSaleReportDTO> getReport() {
        return billOfSaleService.getBillOfSaleReport();
    }

}
