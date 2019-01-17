package com.nc.webapp.controller;

import com.nc.webapp.dto.StoreSaleReportDTO;
import com.nc.webapp.service.StoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store-sales-reports")
class StoreSalesReportyController {

    private final StoreService storeService;

    public StoreSalesReportyController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<StoreSaleReportDTO> getReport() {
        return storeService.getStoreSaleReport();
    }

}
