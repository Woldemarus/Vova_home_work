-- Создание последовательностей
create sequence client_seq start with 1 increment by 1;
create sequence address_seq start with 1 increment by 1;
create sequence phone_seq start with 1 increment by 1;

-- Создание таблицы адресов
create table address
(
    id   bigint not null primary key,
    street varchar(255)
);

-- Создание таблицы клиентов
create table client
(
    id   bigint not null primary key,
    name varchar(50),
    address_id bigint references address(id)
);

-- Создание таблицы телефонов с каскадным удалением
create table phone
(
    id   bigint not null primary key,
    number varchar(20),
    client_id bigint references client(id) on delete cascade
);
