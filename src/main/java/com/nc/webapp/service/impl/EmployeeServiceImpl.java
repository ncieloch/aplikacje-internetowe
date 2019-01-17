package com.nc.webapp.service.impl;

import com.nc.webapp.exception.AppRuntimeException;
import com.nc.webapp.exception.code.AppExceptionCode;
import com.nc.webapp.model.Employee;
import com.nc.webapp.repository.EmployeeRepository;
import com.nc.webapp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return saveEmployeeIfNotNull(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return updateEmployeeIfNotNull(employee);
    }

    private Employee updateEmployeeIfNotNull(Employee employee) throws AppRuntimeException {
        if (employee == null) {
            throw new AppRuntimeException(AppExceptionCode.E003);
        }
        return employeeRepository.save(employee);
    }

    private Employee saveEmployeeIfNotNull(Employee employee) throws AppRuntimeException {
        if (employee == null) {
            throw new AppRuntimeException(AppExceptionCode.E003);
        }
        checkIfUserExist(employee.getIdEmployee());
        return employeeRepository.save(employee);
    }

    private void checkIfUserExist(Integer idEmployee) throws AppRuntimeException {
        try {
            Employee employeeToCheckIfExists = employeeRepository.findById(idEmployee).get();
            throw new AppRuntimeException(AppExceptionCode.E004);
        } catch (NoSuchElementException e) {
            return;
        }
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.getOne(id);
    }
}
