package com.nc.webapp.controller;

import com.nc.webapp.dto.SectionDTO;
import com.nc.webapp.model.Section;
import com.nc.webapp.service.SectionService;
import com.nc.webapp.util.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sections")
class SectionController {

    private final SectionService sectionService;
    private final ModelMapper modelMapper;

    public SectionController(SectionService sectionService,
                             ModelMapper modelMapper) {
        this.sectionService = sectionService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SectionDTO> getAll() {
        return sectionService.getAll()
                .stream()
                .map(section -> modelMapper.map(section, SectionDTO.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SectionDTO getById(@PathVariable Integer id) {
        Section section = RestPreconditions.checkFound(sectionService.getById(id));
        return modelMapper.map(section, SectionDTO.class);
    }

}
