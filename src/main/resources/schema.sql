CREATE TABLE public.person
(
    id bigint PRIMARY KEY NOT NULL,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    middle_name varchar NOT NULL,
    phone bigint NOT NULL,
    address varchar,
    column_7 int,
    birth_data timestamp NOT NULL
);
CREATE UNIQUE INDEX person_phone_uindex ON public.person (phone);
CREATE UNIQUE INDEX person_id_uindex ON public.person (id);


CREATE TABLE public.customer
(
    phone bigint PRIMARY KEY NOT NULL,
    password varchar NOT NULL
);
CREATE UNIQUE INDEX customer_phone_uindex ON public.customer (phone);