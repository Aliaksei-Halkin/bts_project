package com.bts.recruiting.servicies;

import com.bts.recruiting.entity.Vacancy;

import java.util.Optional;

public interface VacancyService {
    Optional<Vacancy> findById(Integer id);
}
