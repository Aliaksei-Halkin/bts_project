package com.bts.recruiting.servicies.impl;

import com.bts.recruiting.entity.Vacancy;
import com.bts.recruiting.repository.VacancyRepository;
import com.bts.recruiting.servicies.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyServiceImpl(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public Optional<Vacancy> findById(Integer id) {
        return vacancyRepository.findById(id);
    }
}
