package com.bts.recruiting.servicies.impl;

import com.bts.recruiting.dtos.OrganizationDto;
import com.bts.recruiting.entity.BadOrganization;
import com.bts.recruiting.repository.BadOrganizationRepository;
import com.bts.recruiting.servicies.BadOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BadOrganizationServiceImpl implements BadOrganizationService {
    private final BadOrganizationRepository badOrganizationRepository;
    @Autowired
    public BadOrganizationServiceImpl(BadOrganizationRepository badOrganizationRepository) {
        this.badOrganizationRepository = badOrganizationRepository;
    }

    @Override
    public Optional<BadOrganization> findBadOrganization(OrganizationDto lastOrganization) {
        return badOrganizationRepository.findByName(lastOrganization.getName());
    }
}
