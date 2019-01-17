package com.nc.webapp.controller;

import com.nc.webapp.dto.ProductDTO;
import com.nc.webapp.model.Product;
import com.nc.webapp.service.ProductService;
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
@RequestMapping("/products")
class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService,
                             ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDTO> getAll() {
        return productService.getAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductDTO productDto) {
        RestPreconditions.checkNotNull(productDto);
        Product product = modelMapper.map(productDto, Product.class);
        return modelMapper.map(productService.createOrUpdate(product), ProductDTO.class);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ProductDTO update(@RequestBody ProductDTO productDto) {
        RestPreconditions.checkNotNull(productDto);
        Product product = modelMapper.map(productDto, Product.class);
        return modelMapper.map(productService.createOrUpdate(product), ProductDTO.class);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductDTO getById(@PathVariable Integer id) {
        Product product = RestPreconditions.checkFound(productService.getById(id));
        return modelMapper.map(product, ProductDTO.class);
    }

}
