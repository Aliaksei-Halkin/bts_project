package com.bts.recruiting.entity;

import com.bts.recruiting.enums.UserDecision;
import com.bts.recruiting.enums.UserQueueLevel;
import com.bts.recruiting.enums.UserSkillLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "\"position\"", nullable = false)
    private Vacancy position;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_level", columnDefinition = "user_skill_level not null")
    private UserSkillLevel skillLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "queue_level", columnDefinition = "user_queue_level")
    private UserQueueLevel queueLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "decision", columnDefinition = "user_decision")
    private UserDecision decision;


    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
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

    @Column(name = "salary")
    private Integer salary;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH})
    private List<UserHasTechnology> userTechnologies;

    @Column(name = "about")
    @Type(type = "org.hibernate.type.TextType")
    private String about;

}