DROP TABLE IF EXISTS statistics;

CREATE TABLE statistics (
                            id        SERIAL PRIMARY KEY NOT NULL,
                            attack    INTEGER NOT NULL,
                            defence   INTEGER NOT NULL,
                            radius    INTEGER NOT NULL
);


DROP TABLE IF EXISTS field;

CREATE TABLE field (
                       id       SERIAL PRIMARY KEY NOT NULL,
                       pos_x    INTEGER NOT NULL,
                       pos_y    INTEGER NOT NULL
);


DROP TABLE IF EXISTS technologies;

CREATE TABLE technologies (
                              id              SERIAL PRIMARY KEY NOT NULL,
                              technology_id   INTEGER NOT NULL
);


DROP TABLE IF EXISTS buildings;

CREATE TABLE buildings (
                           id           SERIAL PRIMARY KEY NOT NULL,
                           building_id  INTEGER NOT NULL
);


DROP TABLE IF EXISTS player;

CREATE TABLE player (
                      id               SERIAL PRIMARY KEY NOT NULL,
                      name             VARCHAR NOT NULL,
                      field_id         INTEGER DEFAULT NULL,
                      statistics_id    INTEGER DEFAULT NULL,
                      technologies_id  INTEGER DEFAULT NULL,

                      CONSTRAINT fk_statistics FOREIGN KEY (statistics_id)
                          REFERENCES statistics (id)
                          ON DELETE CASCADE,

                      CONSTRAINT fk_fields FOREIGN KEY (field_id)
                          REFERENCES field (id),

                      CONSTRAINT fk_technologies FOREIGN KEY (technologies_id)
                          REFERENCES technologies (id)
);


DROP TABLE IF EXISTS planets;

CREATE TABLE planets (
                         id            SERIAL PRIMARY KEY NOT NULL,
                         name          VARCHAR NOT NULL,
                         is_colonized  BOOLEAN DEFAULT FALSE,
                         field_id      INTEGER NOT NULL,
                         buildings_id  INTEGER DEFAULT NULL,

                         CONSTRAINT fk_fields FOREIGN KEY (field_id)
                             REFERENCES field (id),

                         CONSTRAINT fk_buildings FOREIGN KEY (buildings_id)
                             REFERENCES buildings (id)
);
