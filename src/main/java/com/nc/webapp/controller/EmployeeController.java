package com.nc.webapp.controller;

import com.nc.webapp.dto.BillOfSaleDTO;
import com.nc.webapp.dto.EmployeeDTO;
import com.nc.webapp.model.BillOfSale;
import com.nc.webapp.model.Employee;
import com.nc.webapp.service.EmployeeService;
import com.nc.webapp.util.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    public EmployeeController(EmployeeService employeeService,
                              ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDto) {
        RestPreconditions.checkNotNull(employeeDto);
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeService.create(employee), EmployeeDTO.class);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDto) {
        RestPreconditions.checkNotNull(employeeDto);
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeService.update(employee), EmployeeDTO.class);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EmployeeDTO getEmployeeById(@PathVariable Integer id) {
        Employee employee = RestPreconditions.checkFound(employeeService.getById(id));
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @RequestMapping(value = "/{id}/bill-of-sale", method = RequestMethod.GET)
    public List<BillOfSaleDTO> getBillOfSales(@PathVariable Integer id) {
        Employee employee = RestPreconditions.checkFound(employeeService.getById(id));
        return employee.getBillOfSales()
                .stream()
                .map(billOfSale -> modelMapper.map(billOfSale, BillOfSaleDTO.class))
                .collect(Collectors.toList());
    }

}
