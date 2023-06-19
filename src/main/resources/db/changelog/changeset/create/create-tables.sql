create table grade
(
    id   bigserial           not null,
    text varchar(255) unique not null,
    primary key (id)
);

create table student
(
    id         bigserial    not null,
    name       varchar(255) not null,
    surname    varchar(255) not null,
    patronymic varchar(255) not null,
    birthday   date         not null,
    grade_id   bigint,
    primary key (id),
    CONSTRAINT fk_student_grade
        FOREIGN KEY (grade_id)
            REFERENCES grade (id)
);