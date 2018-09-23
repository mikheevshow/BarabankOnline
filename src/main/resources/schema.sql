CREATE TABLE public.customer
(
    phone bigint NOT NULL,
    password varchar,
    customer_id bigint PRIMARY KEY NOT NULL
);
CREATE UNIQUE INDEX customer_phone_uindex ON public.customer (phone);
CREATE UNIQUE INDEX customer_customer_id_uindex ON public.customer (customer_id);


CREATE TABLE public.person
(
    passport_id bigint PRIMARY KEY NOT NULL,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    middle_name varchar NOT NULL,
    customer_id bigint NOT NULL,
    address varchar,
    birth_date varchar NOT NULL,
    CONSTRAINT person_customer_customer_id_fk FOREIGN KEY (customer_id) REFERENCES public.customer (customer_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE public.account
(
    account_id bigint PRIMARY KEY NOT NULL,
    balance numeric NOT NULL,
    customer_id bigint NOT NULL,
    CONSTRAINT account_customer_customer_id_fk FOREIGN KEY (customer_id) REFERENCES public.customer (customer_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE public.transaction
(
    transaction_id bigint PRIMARY KEY NOT NULL,
    from_account bigint NOT NULL,
    to_account bigint NOT NULL,
    sum numeric NOT NULL,
    date timestamp
);

CREATE sequence account_id_seq
    minvalue 1
    start with 1
    increment by 20;

CREATE sequence customer_id_seq
    minvalue 1
    start with 1
    increment by 20;

CREATE sequence transaction_id_seq
    minvalue 1
    start with 1
    increment by 20;

CREATE sequence bankCard_id_seq
    minvalue 1
    start with 1
    increment by 20;