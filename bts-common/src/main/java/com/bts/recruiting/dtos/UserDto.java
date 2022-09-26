package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.User;
import com.bts.recruiting.enums.UserDecision;
import com.bts.recruiting.enums.UserQueueLevel;
import com.bts.recruiting.enums.UserSkillLevel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
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
    @NotBlank
    @Pattern(regexp = "[a-zA-Z\\-]{2,50}", message = "First name should be at least 2 "
            + "letters long and contain English alphabet letters only")
    private String name;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z\\-]{2,50}", message = "Last name should be at least 2 "
            + "letters long and contain English alphabet letters only")
    private String surname;
    private String patronymic;
    @Past
    private LocalDate birthdate;
    @Valid
    private VacancyDto position;
    private UserSkillLevel skillLevel;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserQueueLevel queueLevel;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserDecision decision;
    @Valid
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