package com.nc.webapp.service.impl;

import com.nc.webapp.model.Section;
import com.nc.webapp.repository.SectionRepository;
import com.nc.webapp.service.SectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section getById(Integer id) {
        return sectionRepository.getOne(id);
    }

    @Override
    public List<Section> getAll() {
        return sectionRepository.findAll();
    }

}
