create table transport_types (
    transport_type_id bigserial primary key,
    title varchar(255) not null
);

create table providers (
    provider_id bigserial primary key,
    department_name varchar(255) not null
);

create table vehicles (
    vehicle_id bigserial primary key,
    number varchar(255),
    model varchar(255),
    transport_type_id bigint references transport_types(transport_type_id),
    provider_id bigint
);

create table drivers (
    driver_id bigserial primary key,
    fullname varchar(255),
    provider_id bigint references providers(provider_id)
);

create table customers (
    customer_id bigserial primary key,
    fullname varchar(255),
    email varchar(255),
    phone_number varchar(255)
);

create table orders (
    order_id bigserial primary key,
    customer_id bigint references customers(customer_id),
    provider_id bigint,
    vehicle_id bigint,
    driver_id bigint,
    transport_type_id bigint references transport_types(transport_type_id),
    status varchar(255),
    customer_fullname varchar(255),
    customer_phone_number varchar(255)
);

insert into transport_types(title)
values
    ('Тип 1'),
    ('Тип 2'),
    ('Тип 3'),
    ('Тип 4'),
    ('Тип 5'),
    ('Тип 6');

insert into providers(department_name)
values
    ('Поставщик 1'),
    ('Поставщик 2'),
    ('Поставщик 3');

insert into vehicles(number, model, transport_type_id, provider_id)
values
    ('123aaa', 'Модель 1', 1, 1),
    ('321qwe', 'Модель 2', 2, 1),
    ('445eee', 'Модель 3', 3, 1),
    ('666fff', 'Модель 4', 5, 2),
    ('111qqq', 'Модель 5', 6, 2),
    ('322vvv', 'Модель 6', 2, 3);

insert into drivers (fullname, provider_id)
values
    ('f i o', 1),
    ('Qq Ww Ee', 1),
    ('Иванов Иван Иванович', 1),
    ('Петров Петр Петрович', 1),
    ('Васильев Василий Васильевич', 2),
    ('Дунаев Никита Юрьевич', 2),
    ('Водителев Водитель Водителевич', 3);

insert into customers (fullname, email, phone_number)
values
    ('Петров Петр Петрович', 'ppp@p.ru', '+7123123123'),
    ('Иванов Иван Иванович', 'iii@i.ru', '+793213123'),
    ('Заказчиков Заказчик Заказчикович', 'zzz@z.ru', '+7123988321');