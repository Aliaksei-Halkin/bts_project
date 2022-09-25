create table if not exists technologies
(
    id          serial      not null,
    name        varchar(20) not null,
    description varchar(200),
    created_at  timestamp default now(),
    updated_at  timestamp default now(),
    archived_at timestamp,
    constraint technologies_pk
        primary key (id)
);
create table if not exists bad_organizations
(
    id             serial      not null,
    ownership_form varchar(5),
    name           varchar(50) not null,
    created_at     timestamp default now(),
    updated_at     timestamp default now(),
    archived_at    timestamp,
    constraint bad_organizations_pk
        primary key (id)
);
create table if not exists bad_users
(
    id         serial      not null,
    name       varchar(50) not null,
    surname    varchar(50) not null,
    patronymic varchar(50) not null,
    birthdate  date,
    constraint bad_users_pk
        primary key (id)
);
create unique index if not exists bad_users_unique
    on bad_users (name, surname, patronymic);

create table if not exists organizations
(
    id             serial      not null,
    ownership_form varchar(5),
    name           varchar(50) not null,
    created_at     timestamp default now(),
    updated_at     timestamp default now(),
    archived_at    timestamp,
    constraint organizations_pk
        primary key (id)
);
create type english_level as enum ('A0','A1','A2','B1','B2','C1','C2');

create table if not exists vacancies
(
    id            serial        not null,
    name          varchar(50)   not null,
    description   text      default ''::text,
    english_level english_level not null,
    experience    integer       not null,
    created_at    timestamp default now(),
    updated_at    timestamp default now(),
    archived_at   timestamp,
    constraint vacancies_pk
        primary key (id)
);

create type user_skill_level as enum ('JUNIOR','MIDDLE','SENIOR','TEAM_LEAD','ARCHITECT');
create type user_queue_level as enum ('FIRST', 'SECOND','MIDDLE','REJECT');
create type user_decision as enum ('HIRE','SEND_TEST_TASK','ADDITIONAL_INTERVIEW','REJECT');

create table if not exists users
(
    id          serial           not null,
    name        varchar(50)      not null,
    surname     varchar(50)      not null,
    patronymic  varchar(50)      not null,
    birthdate   date,
    position    integer          not null
        constraint position_vacancies_id_fk references vacancies (id)
            on update restrict on delete restrict,
    skill_level user_skill_level not null,
    queue_level user_queue_level,

    constraint users_pk
        primary key (id)
);
create table if not exists user_has_technologies
(
    id            serial not null primary key,
    user_id       bigint not null
        constraint user_has_technologies_user_id references users (id)
            on update restrict on delete restrict,
    technology_id int    not null
        constraint user_has_technologies_technology_id references technologies (id)
            on update restrict on delete restrict,
    created_at    timestamp default now()
);
create unique index if not exists user_has_technologies_user_id_technology_id
    on user_has_technologies (user_id, technology_id);