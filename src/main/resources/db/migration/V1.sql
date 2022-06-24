CREATE SEQUENCE IF NOT EXISTS hibernate_sequence;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE drivetrain AS ENUM ('FRONT', 'REAR', 'ALL');

CREATE TYPE color AS ENUM (
  'METALLIC WHITE', 'METALLIC BLACK', 'METALLIC GRAY', 'METALLIC BROWN', 'METALLIC RED', 'METALLIC BLUE',
    'METALLIC GREEN', 'METALLIC GOLD', 'METALLIC ORANGE', 'METALLIC YELLOW', 'METALLIC PURPLE');

CREATE TYPE transmission_type AS ENUM ('AUTOMATIC', 'MECHANICAL', 'ROBOT', 'CVT');

CREATE TYPE engine_type AS ENUM ('GASOLINE', 'DIESEL', 'HYBRID', 'ELECTRICAL');

CREATE TYPE role_type AS ENUM ('SELLER', 'CUSTOMER', 'ADMIN', 'MODERATOR');

CREATE TABLE IF NOT EXISTS engine
(
    id          uuid      default uuid_generate_v4() not null
        constraint engine_pkey
            primary key,
    name        varchar                              not null,
    engine_type engine_type                          not null,
    volume      float                                not null,
    power       int                                  not null,
    torque      int                                  not null,
    fuel        int                                  not null,
    warranty    varchar,
    created_at  timestamp default now()              not null,
    updated_at  timestamp default now()              not null
);

CREATE TABLE IF NOT EXISTS transmission
(
    id                uuid      default uuid_generate_v4() not null
        constraint transmission_pkey
            primary key,
    name              varchar                              not null,
    transmission_type transmission_type                    not null,
    number_gears      int                                  not null,
    created_at        timestamp default now()              not null,
    updated_at        timestamp default now()              not null
);

CREATE TABLE IF NOT EXISTS wheel
(
    id           uuid      default uuid_generate_v4() not null
        constraint wheel_pkey
            primary key,
    name         varchar                              not null,
    diameter     float,
    width        float                                not null,
    number_holes int                                  not null,
    bolt_pattern varchar                              not null,
    weight       float                                not null,
    created_at   timestamp default now()              not null,
    updated_at   timestamp default now()              not null
);

CREATE TABLE IF NOT EXISTS model
(
    id               uuid      default uuid_generate_v4() not null
        constraint model_pkey
            primary key,
    name             varchar                              not null,
    drivetrain       drivetrain                           not null,
    fuel_consumption float                                not null,
    color            color,
    created_at       timestamp default now()              not null,
    updated_at       timestamp default now()              not null,
    engine_id        uuid
        constraint model_engine_fkey
            references engine,
    transmission_id  uuid
        constraint model_transmission_fkey
            references transmission,
    wheel_id         uuid
        constraint model_wheel_fkey
            references wheel
);

CREATE TABLE IF NOT EXISTS car
(
    id            uuid      default uuid_generate_v4() not null
        constraint car_pkey
            primary key,
    brand         varchar                              not null,
    year_of_issue timestamp                            not null,
    mileage       bigint,
    price         decimal,
    created_at    timestamp default now()              not null,
    updated_at    timestamp default now()              not null,
    model_id      uuid
        constraint car_model_fkey
            references model
);

CREATE TABLE IF NOT EXISTS factory
(
    id           uuid      default uuid_generate_v4() not null
        constraint factory_pkey
            primary key,
    factory_name varchar                              not null,
    country      varchar                              not null,
    region       varchar                              not null,
    city         varchar                              not null,
    employees    int                                  not null,
    created_at   timestamp default now()              not null,
    updated_at   timestamp default now()              not null
);

CREATE TABLE IF NOT EXISTS model_factory
(
    id         uuid not null,
    factory_id uuid
        constraint model_factory_factory_fkey
            references factory,
    model_id   uuid
        constraint model_factory_model_fkey
            references model
);

CREATE TABLE IF NOT EXISTS app_user
(
    id        uuid     default uuid_generate_v4()      not null
        constraint user_pkey
            primary key,
    firstname           varchar                        not null,
    lastname            varchar                        not null,
    telephone_number    int                            not null,
    email               varchar                        not null,
    created_at  timestamp default now()                not null,
    updated_at  timestamp default now()                not null
);

CREATE TABLE IF NOT EXISTS role
(
    id          uuid      default uuid_generate_v4() not null
        constraint role_pkey
            primary key,
    role_type   role_type                            not null,
    description varchar                              not null,
    created_at  timestamp default now()              not null,
    updated_at  timestamp default now()              not null
);

CREATE TABLE IF NOT EXISTS user_role
(
   id           uuid      not null,
   user_id  uuid
     constraint app_user_role_app_user_fkey
        references app_user,
   role_id      uuid
     constraint app_user_role_role_fkey
        references role
);