create table if not exists authors
(
    id   bigserial
        constraint authors_pk
            primary key,
    name varchar(2048) not null
);

create unique index if not exists authors_id_uindex
    on authors (id);

create unique index if not exists authors_name_uindex
    on authors (name);

create table if not exists messages
(
    id        bigserial
        primary key,
    text      varchar(5000) not null,
    author_id bigint
        constraint messages_authors_id_fk
            references authors
);

create unique index if not exists messages_pkey
    on messages (id);



