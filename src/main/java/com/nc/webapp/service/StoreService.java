package com.nc.webapp.service;

import com.nc.webapp.dto.StoreSaleReportDTO;
import com.nc.webapp.model.Store;

import java.util.List;

public interface StoreService {
    List<Store> getAll();
    Store getById(Integer id);
    List<StoreSaleReportDTO> getStoreSaleReport();
}
