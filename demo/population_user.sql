create table user
(
    id       varchar(20) not null,
    name     varchar(30) not null,
    password varchar(30) not null,
    email    varchar(40) not null,
    constraint user_id_uindex
        unique (id)
);

alter table user
    add primary key (id);

