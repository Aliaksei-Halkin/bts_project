package com.bts.recruiting.entity;

import com.bts.recruiting.services.EnglishLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
@Data
@NoArgsConstructor
@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description")
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @Column(name = "experience", nullable = false)
    private Integer experience;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "archived_at")
    private Instant archivedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "english_level", columnDefinition = "english_level not null")
    private EnglishLevel englishLevel;
}