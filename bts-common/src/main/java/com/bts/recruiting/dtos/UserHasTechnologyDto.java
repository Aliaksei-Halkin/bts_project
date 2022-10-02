package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.UserHasTechnology;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link UserHasTechnology} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserHasTechnologyDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4651522834361951395L;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private UserDto user;
    private TechnologyDto technologyDto;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdAt;
}