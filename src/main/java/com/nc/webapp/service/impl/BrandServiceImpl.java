package com.nc.webapp.service.impl;

import com.nc.webapp.model.Brand;
import com.nc.webapp.repository.BrandRepository;
import com.nc.webapp.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.getOne(id);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

}
