DROP TABLE IF EXISTS statistics;

CREATE TABLE statistics (
                            id        UUID PRIMARY KEY NOT NULL,
                            attack    INTEGER NOT NULL,
                            defence   INTEGER NOT NULL,
                            radius    INTEGER NOT NULL
);


DROP TABLE IF EXISTS field;

CREATE TABLE field (
                       id            UUID PRIMARY KEY NOT NULL,
                       pos_x         INTEGER NOT NULL,
                       pos_y         INTEGER NOT NULL
);


DROP TABLE IF EXISTS technologies;

CREATE TABLE technologies (
                              id              UUID PRIMARY KEY NOT NULL,
                              technology_id   UUID NOT NULL
);


DROP TABLE IF EXISTS buildings;

CREATE TABLE buildings (
                           id           UUID PRIMARY KEY NOT NULL,
                           building_id  UUID NOT NULL
);


DROP TABLE IF EXISTS player;

CREATE TABLE player (
                      id               UUID PRIMARY KEY NOT NULL,
                      name             VARCHAR NOT NULL,
                      field_id         UUID DEFAULT NULL,
                      statistics_id    UUID DEFAULT NULL,
                      technologies_id  UUID DEFAULT NULL,
                      user_id          UUID NOT NULL,

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
                         id            UUID PRIMARY KEY NOT NULL,
                         name          VARCHAR NOT NULL,
                         is_colonized  BOOLEAN DEFAULT FALSE,
                         field_id      UUID NOT NULL,
                         buildings_id  UUID DEFAULT NULL,

                         CONSTRAINT fk_fields FOREIGN KEY (field_id)
                             REFERENCES field (id),

                         CONSTRAINT fk_buildings FOREIGN KEY (buildings_id)
                             REFERENCES buildings (id)
);
