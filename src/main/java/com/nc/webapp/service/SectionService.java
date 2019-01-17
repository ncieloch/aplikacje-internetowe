package com.nc.webapp.service;

import com.nc.webapp.model.Section;

import java.util.List;

public interface SectionService {
    Section getById(Integer id);
    List<Section> getAll();
}
