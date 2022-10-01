package com.bts.recruiting.repository;

import com.bts.recruiting.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

    Optional<Technology> findByName(String name);
}