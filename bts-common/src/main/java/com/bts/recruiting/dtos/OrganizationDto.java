package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.Organization;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Organization} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrganizationDto implements Serializable {
    private Integer id;
    private String ownershipForm;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime archivedAt;
}