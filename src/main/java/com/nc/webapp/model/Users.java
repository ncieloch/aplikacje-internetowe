package com.nc.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="users")
public class Users {
    @Id
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "passwd", nullable = false)
    private String passwd;
}
