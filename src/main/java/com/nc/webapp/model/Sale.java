package com.nc.webapp.model;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name ="sprzedaz")
public class Sale {
    @Id
    @Column(name = "id_sprzedaz", nullable = false)
    private Integer idSale;
    @Basic
    @Column(name = "ilosc_produktu", nullable = true, length = 10)
    private String productAmount;
    @ManyToOne
    @JoinColumn(name = "id_sklep", referencedColumnName = "id_sklep")
    private Store store;
    @ManyToOne
    @JoinColumn(name = "id_dokumentsprzedazy", referencedColumnName = "id_dokumentsprzedazy")
    private BillOfSale billOfSale;
    @ManyToOne
    @JoinColumn(name = "id_produkt", referencedColumnName = "id_produkt")
    private Product product;

}
