package com.bts.recruiting.servicies.impl;

import com.bts.recruiting.dtos.OrganizationDto;
import com.bts.recruiting.entity.Organization;
import com.bts.recruiting.repository.OrganizationRepository;
import com.bts.recruiting.servicies.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
        @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Optional<Organization> findByName(String name) {
        return organizationRepository.findByName(name);
    }

    @Override
    public Organization add(OrganizationDto lastOrganization) {
            Organization organization = new Organization();
            organization.setName(lastOrganization.getName());
            organization.setOwnershipForm(lastOrganization.getOwnershipForm());
        return organizationRepository.save(organization);
    }
}
