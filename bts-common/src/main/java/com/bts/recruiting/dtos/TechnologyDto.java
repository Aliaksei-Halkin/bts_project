package com.bts.recruiting.dtos;

import com.bts.recruiting.entity.Technology;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Technology} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TechnologyDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -8323164311605516626L;
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime archivedAt;
}