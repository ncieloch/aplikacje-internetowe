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
@Table(name = "dostawa")
public class Delivery {
    @Id
    @Column(name = "id_dostawa", nullable = false)
    private Integer idDelivery;
    @Basic
    @Column(name = "ilosc_produktu", nullable = true)
    private Integer productAmount;
    @Basic
    @Column(name = "data_dostawy", nullable = true)
    private LocalDateTime deliveryDate;
    @Basic
    @Column(name = "data_w_zamowienia", nullable = true)
    private LocalDateTime datePOrder;
    @ManyToOne
    @JoinColumn(name = "id_produkt", referencedColumnName = "id_produkt")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_dostawca", referencedColumnName = "id_dostawca")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "id_zamowienie", referencedColumnName = "id_zamowienie")
    private Order order;

}
