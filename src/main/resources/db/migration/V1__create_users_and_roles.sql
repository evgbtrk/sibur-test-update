create table users (
    username varchar(50),
    password varchar (100),
    enabled boolean,
    primary key (username)
);

insert into users
values
('admin', 'admin', true),
('customer', 'customer', true),
('prodiver', 'prodier', true),
('manager', 'manager', true);

create table authorities (
    username varchar (50) not null,
    authority varchar (50) not null,
    constraint authorities_idx unique (username, authority),
    constraint authorities_userfk foreign key (username) references users (username)
);

insert into authorities
values
('admin', 'ROLE_ADMIN'),
('admin', 'ROLE_CUSTOMER'),
('admin', 'ROLE_PROVIDER'),
('admin', 'ROLE_MANAGER'),
('customer', 'ROLE_CUSTOMER'),
('prodiver', 'ROLE_PROVIDER'),
('manager', 'ROLE_MANAGER');
