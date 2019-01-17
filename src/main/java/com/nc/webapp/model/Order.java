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
@Table(name ="zamowienie")
public class Order {
    @Id
    @Column(name = "id_zamowienie", nullable = false)
    private Integer idOrder;
    @Basic
    @Column(name = "ilosc_produktu", nullable = true)
    private Integer productAmount;
    @Basic
    @Column(name = "data_zamowienia", nullable = true)
    private LocalDateTime orderDate;
    @Basic
    @Column(name = "przwidywana_data_dostarczenia", nullable = true)
    private LocalDateTime predictedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "id_dostawca", referencedColumnName = "id_dostawca")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "id_magazyn", referencedColumnName = "id_magazyn")
    private Warehouse warehouse;
    @ManyToOne
    @JoinColumn(name = "id_produkt", referencedColumnName = "id_produkt")
    private Product product;
    @OneToMany(mappedBy = "order")
    private List<Delivery> deliveries;

}