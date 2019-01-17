package com.nc.webapp.service;

import com.nc.webapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee update(Employee employee);
    List<Employee> getAll();
    Employee getById(Integer id);
}
