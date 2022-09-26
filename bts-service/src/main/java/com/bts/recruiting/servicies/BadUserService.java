package com.bts.recruiting.servicies;

import com.bts.recruiting.entity.User;

import java.util.Optional;

public interface BadUserService {
    Optional<User> findUser(String name, String surname, String patronymic);
}
