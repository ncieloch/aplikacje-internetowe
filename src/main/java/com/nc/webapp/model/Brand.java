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
@Table(name = "marka")
public class Brand {
    @Id
    @Column(name = "id_marka", nullable = false)
    private Integer idBrand;
    @Basic
    @Column(name = "nazwa_marki", nullable = true, length = 50)
    private String brandName;
    @ManyToOne
    @JoinColumn(name = "id_producent", referencedColumnName = "id_producent")
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "brand")
    private List<Product> products;

}
