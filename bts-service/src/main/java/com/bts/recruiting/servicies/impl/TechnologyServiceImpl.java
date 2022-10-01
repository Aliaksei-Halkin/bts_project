package com.bts.recruiting.servicies.impl;

import com.bts.recruiting.entity.Technology;
import com.bts.recruiting.repository.TechnologyRepository;
import com.bts.recruiting.servicies.TechnologyService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    private final TechnologyRepository technologyRepository;

    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public Optional<Technology> findById(Integer id) {
        return technologyRepository.findById(id);
    }

    @Override
    public Optional<Technology> findByName(String name) {
        return technologyRepository.findByName(name);
    }
}
