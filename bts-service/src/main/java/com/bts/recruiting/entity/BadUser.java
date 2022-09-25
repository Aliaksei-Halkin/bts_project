package com.bts.recruiting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity
@Table(name = "bad_users")
public class BadUser {
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

}