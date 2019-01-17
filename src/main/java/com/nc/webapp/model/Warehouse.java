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
@Table(name ="magazyn")
public class Warehouse {
    @Id
    @Column(name = "id_magazyn", nullable = false)
    private Integer idWarehouse;
    @Basic
    @Column(name = "adres_magazynu", nullable = true, length = 300)
    private String warehouseAddress;
    @OneToMany(mappedBy = "warehouse")
    private List<Store> warehouses;
    @OneToMany(mappedBy = "warehouse")
    private List<Order> orders;

}
