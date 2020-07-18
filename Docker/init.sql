CREATE TABLE recipe (
    recipe_id INTEGER PRIMARY KEY,
    name VARCHAR NOT NULL,
    description VARCHAR
);
CREATE TABLE ingredient (
    id INTEGER PRIMARY KEY,
    name VARCHAR NOT NULL,
    amount INTEGER NOT NULL,
    unit VARCHAR NOT NULL,
    recipe_id INTEGER REFERENCES recipe(recipe_id)
);
CREATE TABLE step (
    id INTEGER PRIMARY KEY,
    text TEXT NOT NULL,
    ordinal INTEGER NOT NULL,
    recipe_id INTEGER REFERENCES recipe(recipe_id)
);
CREATE TABLE tag (
    id INTEGER PRIMARY KEY,
    text VARCHAR NOT NULL,
    ordinal INTEGER NOT NULL,
    recipe_id INTEGER REFERENCES recipe(recipe_id)
);
create sequence hibernate_sequence start with 1 increment by 50;
grant usage, select on all sequences in schema public to docker;
