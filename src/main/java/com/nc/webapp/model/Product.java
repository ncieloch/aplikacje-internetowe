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
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "produkt")
public class Product {
    @Id
    @Column(name = "id_produkt", nullable = false)
    private Integer idProduct;
    @Basic
    @Column(name = "nazwa_produktu", nullable = true, length = 500)
    private String productName;
    @Basic
    @Column(name = "cena_produktu", nullable = true, precision = 3)
    private BigDecimal productPrice;
    @OneToMany(mappedBy = "product")
    private List<Delivery> deliveries;
    @ManyToOne
    @JoinColumn(name = "id_marka", referencedColumnName = "id_marka")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "id_dzial", referencedColumnName = "id_dzial")
    private Section section;
    @OneToMany(mappedBy = "product")
    private List<Order> orders;
    @OneToMany(mappedBy = "product")
    private List<Sale> sales;


}
