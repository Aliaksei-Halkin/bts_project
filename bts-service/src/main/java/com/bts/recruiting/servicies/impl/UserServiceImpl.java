package com.bts.recruiting.servicies.impl;

import com.bts.recruiting.dtos.UserDto;
import com.bts.recruiting.repository.UserRepository;
import com.bts.recruiting.servicies.BadOrganizationService;
import com.bts.recruiting.servicies.BadUserService;
import com.bts.recruiting.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BadUserService badUserService;
    private final BadOrganizationService badOrganizationService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BadUserService badUserService, BadOrganizationService badOrganizationService) {
        this.userRepository = userRepository;
        this.badUserService = badUserService;
        this.badOrganizationService = badOrganizationService;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        boolean badUser = isBadUsers(userDto);
        boolean badOrganization = isBadOrganizations(userDto);

        return null;
    }

    private boolean isBadOrganizations(UserDto userDto) {
        return badOrganizationService.findBadOrganization(userDto.getLastOrganization()).isPresent();

    }

    private boolean isBadUsers(UserDto userDto) {
        return badUserService.findUser(userDto.getName(), userDto.getSurname(), userDto.getPatronymic())
                .isPresent();
    }
}
