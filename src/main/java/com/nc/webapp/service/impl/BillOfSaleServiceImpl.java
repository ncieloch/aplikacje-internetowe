package com.nc.webapp.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nc.webapp.dto.BillOfSaleReportDTO;
import com.nc.webapp.model.BillOfSale;
import com.nc.webapp.model.Sale;
import com.nc.webapp.repository.BillOfSaleRepository;
import com.nc.webapp.service.BillOfSaleService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class BillOfSaleServiceImpl implements BillOfSaleService {

    private final BillOfSaleRepository billOfSaleRepository;

    public BillOfSaleServiceImpl(BillOfSaleRepository billOfSaleRepository) {
        this.billOfSaleRepository = billOfSaleRepository;
    }

    @Override
    public List<BillOfSaleReportDTO> getBillOfSaleReport() {
        List<BillOfSaleReportDTO> billOfSaleReport = Lists.newArrayList();

        for (int i = 1; i <= 12; i++) {
            List<BillOfSale> billOfSales = billOfSaleRepository.findBillOfSaleForSpecificMonth(i);
            int count = 0;
            for (BillOfSale b : billOfSales) {
                count += countSoldProducts(b);
            }
            BillOfSaleReportDTO report = buildBillOfSaleReport(getMonthName(i), count);
            billOfSaleReport.add(report);
        }

        return billOfSaleReport;
    }

    private int countSoldProducts(BillOfSale billOfSale) {
        int count = 0;
        for (Sale sale : billOfSale.getSales()) {
            String productAmount = sale.getProductAmount().replaceAll("\\s+","");
            count += Integer.parseInt(productAmount);
        }
        return count;
    }

    private String getMonthName(int monthNumber) {
        switch(monthNumber) {
            case 1:
                return "Styczeń";
            case 2:
                return "Luty";
            case 3:
                return "Marzec";
            case 4:
                return "Kwiecień";
            case 5:
                return "Maj";
            case 6:
                return "Czerwiec";
            case 7:
                return "Lipiec";
            case 8:
                return "Sierpień";
            case 9:
                return "Wrzesień";
            case 10:
                return "Październik";
            case 11:
                return "Listopad";
            case 12:
                return "Grudzień";
            default:
                return "Błąd";
        }
    }

    private BillOfSaleReportDTO buildBillOfSaleReport(String monthName, int count) {
        return BillOfSaleReportDTO.builder()
                .month(monthName)
                .soldCount(count)
                .build();
    }

}
