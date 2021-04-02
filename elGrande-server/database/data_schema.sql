CREATE TABLE player (
                      id       SERIAL PRIMARY KEY NOT NULL,
                      name     CHAR(250) NOT NULL,
                      pos_x    INTEGER,
                      pos_y    INTEGER
);

CREATE TABLE planets (
                         id         SERIAL PRIMARY KEY NOT NULL,
                         name       CHAR(250) NOT NULL,
                         pos_x      INTEGER NOT NULL,
                         pos_y      INTEGER NOT NULL,
                         colonized  BOOLEAN NOT NULL
)
