package com.bts.recruiting.servicies.impl;

import com.bts.recruiting.dtos.UserDto;
import com.bts.recruiting.repository.UserRepository;
import com.bts.recruiting.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto addUser(UserDto userDto) {


        return null;
    }
}
