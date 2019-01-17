package com.nc.webapp.controller;

import com.nc.webapp.dto.StoreDTO;
import com.nc.webapp.model.Store;
import com.nc.webapp.service.StoreService;
import com.nc.webapp.util.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stores")
class StoreController {

    private final StoreService storeService;
    private final ModelMapper modelMapper;

    public StoreController(StoreService storeService,
                           ModelMapper modelMapper) {
        this.storeService = storeService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<StoreDTO> getAll() {
        return storeService.getAll()
                .stream()
                .map(store -> modelMapper.map(store, StoreDTO.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StoreDTO getById(@PathVariable Integer id) {
        Store store = RestPreconditions.checkFound(storeService.getById(id));
        return modelMapper.map(store, StoreDTO.class);
    }

}
