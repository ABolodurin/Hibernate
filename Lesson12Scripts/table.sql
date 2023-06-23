-- Table: public.items

DROP TABLE IF EXISTS items;

CREATE TABLE items(
	item_id serial NOT NULL PRIMARY KEY,
	val int NOT NULL,
    version integer DEFAULT 0
);