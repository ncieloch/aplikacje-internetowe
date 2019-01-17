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
@Table(name = "pracownik")
public class Employee {

    @Id
    @Column(name = "id_pracownik", nullable = false)
    private Integer idEmployee;
    @Basic
    @Column(name = "imie_pracownika", length = 50)
    private String employeeName;
    @Basic
    @Column(name = "nazwisko_pracownika", length = 50)
    private String employeeSurname;
    @Basic
    @Column(name = "email", length = 150)
    private String email;
    @Basic
    @Column(name = "nr_telefonu", length = 12)
    private String telephoneNumber;
    @Basic
    @Column(name = "stanowisko", length = 100)
    private String position;
    @OneToMany(mappedBy = "employee")
    private List<BillOfSale> billOfSales;

}
