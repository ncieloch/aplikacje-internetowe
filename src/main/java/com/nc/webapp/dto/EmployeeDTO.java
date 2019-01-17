package com.nc.webapp.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Integer idEmployee;
    private String employeeName;
    private String employeeSurname;
    private String email;
    private String telephoneNumber;
    private String position;
}
