package com.bts.recruiting.servicies;

import com.bts.recruiting.entity.Technology;

import java.util.Optional;

public interface TechnologyService {
    public Optional<Technology> findById(Integer id);
    public Optional<Technology> findByName(String name);
}
