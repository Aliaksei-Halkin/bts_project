package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.User;
import com.bts.recruiting.enums.UserDecision;
import com.bts.recruiting.enums.UserQueueLevel;
import com.bts.recruiting.enums.UserSkillLevel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthdate;
    private VacancyDto position;
    private UserSkillLevel skillLevel;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserQueueLevel queueLevel;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserDecision decision;
    private OrganizationDto lastOrganization;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime archivedAt;
}