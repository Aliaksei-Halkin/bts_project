package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.Vacancy;
import com.bts.recruiting.enums.EnglishLevel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Vacancy} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class VacancyDto implements Serializable {
    @Positive
    private Integer id;
    @NotBlank
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String description;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer experience;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant createdAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant updatedAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant archivedAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private EnglishLevel englishLevel;
}