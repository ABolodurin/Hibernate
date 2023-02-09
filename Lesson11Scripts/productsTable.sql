CREATE TABLE IF NOT EXISTS public.products
(
    id serial NOT NULL,
    name text NOT NULL,
    price integer NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id)
);
