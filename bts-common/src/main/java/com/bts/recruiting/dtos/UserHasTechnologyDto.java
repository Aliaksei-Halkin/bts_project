package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.UserHasTechnology;
import lombok.*;

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
    private Integer id;
    private UserDto user;
    private TechnologyDto technologyDto;
    private LocalDateTime createdAt;
}