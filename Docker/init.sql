CREATE TABLE recipe (
    id INTEGER PRIMARY KEY,
    name VARCHAR NOT NULL,
    description VARCHAR
);
CREATE TABLE ingredient (
    id INTEGER PRIMARY KEY,
    name VARCHAR NOT NULL,
    amount INTEGER NOT NULL,
    unit VARCHAR NOT NULL,
    recipe_id INTEGER REFERENCES recipe(id)
);
CREATE TABLE step (
    id INTEGER PRIMARY KEY,
    text TEXT NOT NULL,
    ordinal INTEGER NOT NULL,
    recipe_id INTEGER REFERENCES recipe(id)
);
CREATE TABLE tag (
    id INTEGER PRIMARY KEY,
    text VARCHAR NOT NULL,
    ordinal INTEGER NOT NULL,
    recipe_id INTEGER REFERENCES recipe(id)
);
