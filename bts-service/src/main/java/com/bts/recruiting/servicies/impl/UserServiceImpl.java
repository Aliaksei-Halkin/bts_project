package com.bts.recruiting.servicies.impl;

import com.bts.recruiting.dtos.OrganizationDto;
import com.bts.recruiting.dtos.UserDto;
import com.bts.recruiting.entity.*;
import com.bts.recruiting.enums.UserDecision;
import com.bts.recruiting.enums.UserQueueLevel;
import com.bts.recruiting.enums.UserSkillLevel;
import com.bts.recruiting.exceptions.BtsException;
import com.bts.recruiting.exceptions.ExceptionCode;
import com.bts.recruiting.mappers.UserMapper;
import com.bts.recruiting.repository.UserHasTechnologyRepository;
import com.bts.recruiting.repository.UserRepository;
import com.bts.recruiting.servicies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BadUserService badUserService;
    private final BadOrganizationService badOrganizationService;
    private final TechnologyService technologyService;
    private final VacancyService vacancyService;
    private final OrganizationService organizationService;
    private final UserHasTechnologyRepository userHasTechnologyRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BadUserService badUserService, BadOrganizationService badOrganizationService, TechnologyService technologyService, VacancyService vacancyService, OrganizationService organizationService, UserHasTechnologyRepository userHasTechnologyRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.badUserService = badUserService;
        this.badOrganizationService = badOrganizationService;
        this.technologyService = technologyService;
        this.vacancyService = vacancyService;
        this.organizationService = organizationService;
        this.userHasTechnologyRepository = userHasTechnologyRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDto addUser(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPatronymic(userDto.getPatronymic());
        user.setBirthdate(userDto.getBirthdate());
        user.setSkillLevel(userDto.getSkillLevel());
        user.setPosition(findVacancy(userDto));
        user.setSkillLevel(userDto.getSkillLevel());
        user.setLastOrganization(findOrCreateOrganization(userDto.getLastOrganization()));
        user.setSalary(userDto.getSalary());
        user.setAbout(user.getAbout());
        List<Technology> technologies = userDto.getTechnologies().stream()
                .map(t -> technologyService.findByName(t).orElseThrow(() -> {
                    throw new BtsException(ExceptionCode.RECORD_NOT_FOUND,
                            String.format("Technology  didn't find:  %s", t));
                }))
                .toList();
        user.setQueueLevel(calculateLevel(userDto, technologies.size()));
        User savedUser = userRepository.save(user);
        List<UserHasTechnology> userHasTechnologiesList = new ArrayList<>();
        technologies.forEach(t -> {
            UserHasTechnology userHasTechnology = new UserHasTechnology();
            userHasTechnology.setUser(savedUser);
            userHasTechnology.setTechnology(t);
            UserHasTechnology savedTechnology = userHasTechnologyRepository.save(userHasTechnology);
            userHasTechnologiesList.add(savedTechnology);
        });
        user.setUserTechnologies(userHasTechnologiesList);
        return userMapper.mapEntityToDto(savedUser);
    }

    @Override
    public UserDto addUserDecision(UserDecision userDecision, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new BtsException(ExceptionCode.RECORD_NOT_FOUND, "User not faund");
        });
        user.setDecision(userDecision);
        user.setArchivedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return userMapper.mapEntityToDto(savedUser);
    }

    @Override
    public Page<UserDto> findAllByStatus(UserQueueLevel userQueueLevel, Pageable pageable) {
        Page<User> allByQueueLevel = userRepository.findUsersByQueueLevel(userQueueLevel, pageable);
        return allByQueueLevel.map(userMapper::mapEntityToDto);
    }

    private UserQueueLevel calculateLevel(UserDto userDto, int technologyQuantity) {
        boolean badUser = isBadUsers(userDto);
        boolean badOrganization = isBadOrganizations(userDto);
        Integer salary = userDto.getSalary();
        UserQueueLevel userQueueLevel = UserQueueLevel.REJECT;
        if (badUser) {
            return UserQueueLevel.REJECT;
        }
        if (!badUser && salary.intValue() > 3000) {
            return UserQueueLevel.THIRD;
        }
        if (salary >= 1000 && salary <= 2000 && (userDto.getSkillLevel() == UserSkillLevel.MIDDLE)
                && !badOrganization && technologyQuantity >= 7) {
            return UserQueueLevel.FIRST;
        }
        if ((salary < 1000 || salary > 2000) && (userDto.getSkillLevel() == UserSkillLevel.JUNIOR ||
                userDto.getSkillLevel() == UserSkillLevel.SENIOR) && !badOrganization && technologyQuantity < 7) {
            return UserQueueLevel.SECOND;
        }
        return userQueueLevel;
    }

    private Vacancy findVacancy(UserDto userDto) {
        return vacancyService.findById(userDto.getPosition().getId()).orElseThrow(() -> {
            throw new BtsException(ExceptionCode.RECORD_NOT_FOUND, String.format("Such vacancy didn't find:  %s",
                    userDto.getPosition().toString()));
        });
    }

    private Organization findOrCreateOrganization(OrganizationDto lastOrganization) {
        Optional<Organization> organizationOptional = organizationService.findByName(lastOrganization.getName());
        return organizationOptional.orElseGet(() -> organizationService.add(lastOrganization));
    }

    private boolean isBadOrganizations(UserDto userDto) {
        return badOrganizationService.findBadOrganization(userDto.getLastOrganization()).isPresent();

    }

    private boolean isBadUsers(UserDto userDto) {
        return badUserService.findUser(userDto.getName(), userDto.getSurname(), userDto.getPatronymic())
                .isPresent();
    }
}
