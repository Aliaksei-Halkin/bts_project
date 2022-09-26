package com.bts.recruiting.repository;

import com.bts.recruiting.entity.BadUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BadUserRepository extends JpaRepository<BadUser, Integer> {
    Optional<BadUser> findByNameAndSurnameAndPatronymic(String name, String Surname, String patronymic);
}