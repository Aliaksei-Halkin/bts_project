package com.bts.recruiting.repository;

import com.bts.recruiting.entity.BadUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadUserRepository extends JpaRepository<BadUser, Integer> {
}