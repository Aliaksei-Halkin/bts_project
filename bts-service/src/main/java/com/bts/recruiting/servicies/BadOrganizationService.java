package com.bts.recruiting.servicies;

import com.bts.recruiting.dtos.OrganizationDto;
import com.bts.recruiting.entity.BadOrganization;

import java.util.Optional;

public interface BadOrganizationService {
    Optional<BadOrganization> findBadOrganization(OrganizationDto lastOrganization);
}
