package com.nc.webapp.repository;

import com.nc.webapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Employee, Integer> {
}
