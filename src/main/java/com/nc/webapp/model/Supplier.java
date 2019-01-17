package com.nc.webapp.model;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "dostawca")
public class Supplier {
    @Id
    @Column(name = "id_dostawca", nullable = false)
    private Integer idSupplier;
    @Basic
    @Column(name = "nazwa_dostawcy", nullable = true, length = 10)
    private String supplierName;
    @OneToMany(mappedBy = "supplier")
    private List<Delivery> deliveries;
    @OneToMany(mappedBy = "supplier")
    private List<Order> orders;

}
