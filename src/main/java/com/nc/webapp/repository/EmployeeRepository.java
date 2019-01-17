package com.nc.webapp.repository;

import com.nc.webapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer > {
}
