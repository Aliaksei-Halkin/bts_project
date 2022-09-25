package com.bts.recruiting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
    @Column(name = "archived_at")
    private Instant archivedAt;

/*
    TODO [JPA Buddy] create field to map the 'english_level' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "english_level", columnDefinition = "english_level not null")
    private Object englishLevel;
*/
}