package com.bts.recruiting.servicies.impl;

import com.bts.recruiting.entity.User;
import com.bts.recruiting.repository.BadUserRepository;
import com.bts.recruiting.servicies.BadUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BadUserServiceImpl implements BadUserService {
    private final BadUserRepository badUserRepository;

    @Autowired
    public BadUserServiceImpl(BadUserRepository badUserRepository) {
        this.badUserRepository = badUserRepository;
    }

    @Override
    public Optional<User> findUser(String name, String surname, String patronymic) {
        return Optional.empty();
    }
}
