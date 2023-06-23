CREATE TABLE IF NOT EXISTS public.orders
(
    id serial NOT NULL,
    customer_id integer NOT NULL,
    product_id integer NOT NULL,
    price integer,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id)
        REFERENCES public.customers (id)
        ON DELETE CASCADE,
    CONSTRAINT fk_product_id FOREIGN KEY (product_id)
        REFERENCES public.products (id)
);
