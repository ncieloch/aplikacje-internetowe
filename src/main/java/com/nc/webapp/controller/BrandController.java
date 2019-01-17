package com.nc.webapp.controller;

import com.nc.webapp.dto.BrandDTO;
import com.nc.webapp.model.Brand;
import com.nc.webapp.service.BrandService;
import com.nc.webapp.util.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brands")
class BrandController {

    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public BrandController(BrandService brandService,
                           ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BrandDTO> getAll() {
        return brandService.getAll()
                .stream()
                .map(brand -> modelMapper.map(brand, BrandDTO.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BrandDTO getById(@PathVariable Integer id) {
        Brand brand = RestPreconditions.checkFound(brandService.getById(id));
        return modelMapper.map(brand, BrandDTO.class);
    }

}
