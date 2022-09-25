package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.Vacancy;
import com.bts.recruiting.enums.EnglishLevel;
import lombok.*;

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
    private Integer id;
    private String name;
    private String description;
    private Integer experience;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant archivedAt;
    private EnglishLevel englishLevel;
}