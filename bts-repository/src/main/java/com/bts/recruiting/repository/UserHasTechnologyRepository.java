package com.bts.recruiting.repository;

import com.bts.recruiting.entity.UserHasTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHasTechnologyRepository extends JpaRepository<UserHasTechnology, Integer> {
}