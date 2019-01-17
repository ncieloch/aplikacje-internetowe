package com.nc.webapp.repository;

import com.nc.webapp.model.BillOfSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillOfSaleRepository extends JpaRepository<BillOfSale, Integer> {
    @Query("SELECT b FROM BillOfSale b WHERE EXTRACT(MONTH FROM b.saleDate) = ?1")
    List<BillOfSale> findBillOfSaleForSpecificMonth(int month);
}
