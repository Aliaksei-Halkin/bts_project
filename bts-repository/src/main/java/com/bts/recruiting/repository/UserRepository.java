package com.bts.recruiting.repository;

import com.bts.recruiting.entity.User;
import com.bts.recruiting.enums.UserQueueLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findUsersByQueueLevel(UserQueueLevel queueLevel, Pageable pageable);
}