package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.User;
import com.bts.recruiting.enums.UserDecision;
import com.bts.recruiting.enums.UserQueueLevel;
import com.bts.recruiting.enums.UserSkillLevel;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link User} entity
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthdate;
    private VacancyDto position;
    private UserSkillLevel skillLevel;
    private UserQueueLevel queueLevel;
    private UserDecision decision;
    private OrganizationDto lastOrganization;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime archivedAt;
}