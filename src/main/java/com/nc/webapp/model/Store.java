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
import java.util.List;

@Data
@Entity
@Table(name = "sklep")
public class Store {
    @Id
    @Column(name = "id_sklep", nullable = false)
    private Integer idStore;
    @Basic
    @Column(name = "adres_sklepu", nullable = true, length = 300)
    private String storeAddress;
    @Basic
    @Column(name = "pozycja_x", precision = 6)
    private Double xPos;
    @Basic
    @Column(name = "pozycja_y", precision = 6)
    private Double yPos;
    @ManyToOne
    @JoinColumn(name = "id_magazyn", referencedColumnName = "id_magazyn")
    private Warehouse warehouse;
    @OneToMany(mappedBy = "store")
    private List<Sale> sales;

}
