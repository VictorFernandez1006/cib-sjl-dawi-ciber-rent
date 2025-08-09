create database if not exists ciber_rent;
use ciber_rent;

insert into users(username, password, full_name)
values
    ('recep', '$2a$12$vu.dpeDgeLSRG6kQ8CPkP.kxSn3ri29GssN.Hh8KnArnRaMjwbCmW', 'Natalie Fernández');

insert into roles(name)
values
    ('ADMIN'),
    ('RECEPCIONISTA');

insert into user_roles (user_id, role_id)
values
    (1, 1),
    (2,2);