package com.nc.webapp.model;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "dokumentsprzedazy")
public class BillOfSale {
    @Id
    @Column(name = "id_dokumentsprzedazy", nullable = false)
    private Integer idBillOfSale;
    @Basic
    @Column(name = "data_sprzedazy")
    private LocalDateTime saleDate;
    @ManyToOne
    @JoinColumn(name = "id_pracownik", referencedColumnName = "id_pracownik")
    private Employee employee;
    @OneToMany(mappedBy = "billOfSale")
    private List<Sale> sales;

}
