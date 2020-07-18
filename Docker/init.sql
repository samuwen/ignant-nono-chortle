CREATE TABLE recipe (
    recipe_id UUID PRIMARY KEY,
    name VARCHAR NOT NULL,
    description VARCHAR
);
CREATE TABLE ingredient (
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL,
    amount INTEGER NOT NULL,
    unit VARCHAR NOT NULL,
    recipe_id UUID REFERENCES recipe(recipe_id)
);
CREATE TABLE step (
    id UUID PRIMARY KEY,
    text TEXT NOT NULL,
    ordinal INTEGER NOT NULL,
    recipe_id UUID REFERENCES recipe(recipe_id)
);
CREATE TABLE tag (
    id UUID PRIMARY KEY,
    text VARCHAR NOT NULL,
    ordinal INTEGER NOT NULL,
    recipe_id UUID REFERENCES recipe(recipe_id)
);
