insert into technologies (name, description)
values ('Java', 'the best language java'),
       ('JS', 'javascript'),
       ('HTML', 'some description'),
       ('CSS', 'some description'),
       ('SQL', 'some description'),
       ('Hibernate', 'some description'),
       ('Swagger', 'some description'),
       ('JPA', 'some description'),
       ('FlyWay', 'some description'),
       ('Liquibase', 'some description'),
       ('Lombok', 'some description'),
       ('Spring boot', 'some description'),
       ('Spring MVC', 'some description'),
       ('Spring Data', 'some description'),
       ('Spring Security', 'some description');
insert into bad_users (name, surname, patronymic, birthdate)
values ('Ivan', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan2', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan3', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan4', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan5', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan6', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan7', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan8', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan9', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan10', 'Ivanov', 'Ivanovich', '11.11.2001'),
       ('Ivan11', 'Ivanov', 'Ivanovich', '11.11.2001');
insert into bad_organizations(ownership_form, name)
values ('ZAO', 'Some_company'),
       ('ZAO', 'Some_company1'),
       ('ZAO', 'Some_company2'),
       ('ZAO', 'Some_company3'),
       ('ZAO', 'Some_company4'),
       ('ZAO', 'Some_company5'),
       ('ZAO', 'Some_company6'),
       ('ZAO', 'Some_company7'),
       ('ZAO', 'Some_company8'),
       ('ZAO', 'Some_company9'),
       ('ZAO', 'Some_company10');
insert into vacancies (name, english_level, experience)
values ('Java developer', 'B1', 2),
       ('Java developer', 'B2', 3),
       ('Java developer', 'C1', 4);
insert into organizations (ownership_form, name)
values ('ZAO', 'MAZ');
insert into users (name, surname, patronymic, birthdate, position, skill_level, last_organization,
                                      salary, about, queue_level)
values ('Alex','Petrov','Petrovich','11.11.1994',1,'JUNIOR',1,1000,'some text','FIRST')
