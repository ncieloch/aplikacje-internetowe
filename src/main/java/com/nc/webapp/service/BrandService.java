package com.nc.webapp.service;

import com.nc.webapp.model.Brand;

import java.util.List;

public interface BrandService {
    Brand getById(Integer id);
    List<Brand> getAll();
}
