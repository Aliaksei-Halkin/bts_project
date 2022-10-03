package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.Vacancy;
import com.bts.recruiting.enums.EnglishLevel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A DTO for the {@link Vacancy} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class VacancyDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6114092178876651475L;
    @Positive
    private Integer id;
    @NotBlank
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String description;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer experience;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime archivedAt;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private EnglishLevel englishLevel;
}