package com.nc.webapp.service.impl;

import com.google.common.collect.Lists;
import com.nc.webapp.dto.StoreSaleReportDTO;
import com.nc.webapp.model.Sale;
import com.nc.webapp.model.Store;
import com.nc.webapp.repository.StoreRepository;
import com.nc.webapp.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store getById(Integer id) {
        return storeRepository.getOne(id);
    }

    @Override
    public List<StoreSaleReportDTO> getStoreSaleReport() {
        List<StoreSaleReportDTO> storeSales = Lists.newArrayList();
        List<Store> stores = storeRepository.findAll();
        for (Store store : stores) {
            StoreSaleReportDTO storeSaleReportDTO
                    = buildProductSalesCountDto(store.getStoreAddress(), countSoldProducts(store));
            storeSales.add(storeSaleReportDTO);
        }
        storeSales.sort(Comparator.comparing(StoreSaleReportDTO::getSoldCount).reversed());

        return storeSales;
    }

    private int countSoldProducts(Store store) {
        int count = 0;
        for (Sale sale : store.getSales()) {
            String productAmount = sale.getProductAmount().replaceAll("\\s+","");
            count += Integer.parseInt(productAmount);
        }
        return count;
    }

    private StoreSaleReportDTO buildProductSalesCountDto(String storeAddress, int count) {
        return StoreSaleReportDTO.builder()
                .storeAddress(storeAddress)
                .soldCount(count)
                .build();
    }

}
