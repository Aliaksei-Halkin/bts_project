package com.bts.recruiting.entity;

import com.bts.recruiting.enums.UserDecision;
import com.bts.recruiting.enums.UserQueueLevel;
import com.bts.recruiting.enums.UserSkillLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "patronymic", nullable = false, length = 50)
    private String patronymic;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"position\"", nullable = false)
    private Vacancy position;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_level", columnDefinition = "user_skill_level not null")
    private UserSkillLevel skillLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "queue_level", columnDefinition = "user_queue_level")
    private UserQueueLevel queueLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "decision", columnDefinition ="user_decision")
    private UserDecision decision;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "last_organization", nullable = false)
    private Organization lastOrganization;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "archived_at")
    private LocalDateTime archivedAt;

}