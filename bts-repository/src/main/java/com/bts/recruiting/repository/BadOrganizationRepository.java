package com.bts.recruiting.repository;

import com.bts.recruiting.entity.BadOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadOrganizationRepository extends JpaRepository<BadOrganization, Integer> {
}