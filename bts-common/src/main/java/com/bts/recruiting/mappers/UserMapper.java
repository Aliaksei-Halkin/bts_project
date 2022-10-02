package com.bts.recruiting.mappers;

import com.bts.recruiting.dtos.OrganizationDto;
import com.bts.recruiting.dtos.UserDto;
import com.bts.recruiting.dtos.VacancyDto;
import com.bts.recruiting.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public UserDto mapEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setPatronymic(user.getPatronymic());
        userDto.setBirthdate(user.getBirthdate());
        userDto.setPosition(modelMapper.map(user.getPosition(), VacancyDto.class));
        userDto.setSkillLevel(user.getSkillLevel());
        userDto.setLastOrganization(modelMapper.map(user.getLastOrganization(), OrganizationDto.class));
        userDto.setDecision(user.getDecision());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());
        userDto.setArchivedAt(user.getArchivedAt());
        userDto.setSalary(user.getSalary());
        userDto.setAbout(user.getAbout());
        userDto.setQueueLevel(user.getQueueLevel());
        userDto.setTechnologies(
                user.getUserTechnologies().stream()
                        .map(ut -> ut.getTechnology().getName())
                        .toList()
        );
        return userDto;
    }
}
