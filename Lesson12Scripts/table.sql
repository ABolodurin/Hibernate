-- Table: public.items

-- DROP TABLE IF EXISTS public.items;

CREATE TABLE items(
	item_id serial NOT NULL PRIMARY KEY,
	val int NOT NULL,
    version integer DEFAULT 0
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.items
    OWNER to postgres;
	