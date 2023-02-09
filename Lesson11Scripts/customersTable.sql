CREATE TABLE IF NOT EXISTS public.customers
(
    id serial NOT NULL,
    name varchar(64) NOT NULL,
    CONSTRAINT customers_pkey PRIMARY KEY (id)
);
