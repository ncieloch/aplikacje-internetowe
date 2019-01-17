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
@Table(name = "producent")
public class Manufacturer {
    @Id
    @Column(name = "id_producent", nullable = false)
    private Integer idManufacturer;
    @Basic
    @Column(name = "nazwa_producenta", nullable = true, length = 50)
    private String manufacturerName;
    @OneToMany(mappedBy = "manufacturer")
    private List<Brand> brands;

}
