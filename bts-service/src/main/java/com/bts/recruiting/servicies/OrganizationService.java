package com.bts.recruiting.servicies;

import com.bts.recruiting.dtos.OrganizationDto;
import com.bts.recruiting.entity.Organization;

import java.util.Optional;

public interface  OrganizationService {
    Optional<Organization> findByName(String name);

    Organization add(OrganizationDto lastOrganization);
}
