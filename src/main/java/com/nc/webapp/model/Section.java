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
@Table(name = "dzial")
public class Section {
    @Id
    @Column(name = "id_dzial", nullable = false)
    private Integer idSection;
    @Basic
    @Column(name = "nazwa_dzialu", nullable = true, length = 50)
    private String sectionName;
    @OneToMany(mappedBy = "section")
    private List<Product> products;
}
