
DROP TABLE IF EXISTS user_registration_data;

CREATE TABLE user_registration_data (
                                        id         SERIAL PRIMARY KEY NOT NULL,
                                        username   VARCHAR UNIQUE NOT NULL,
                                        password   VARCHAR NOT NULL,
                                        enabled    INT2 NOT NULL DEFAULT 1
);


DROP TABLE IF EXISTS authorities;

CREATE TABLE authorities (
                             id        SERIAL PRIMARY KEY NOT NULL,
                             username  VARCHAR UNIQUE NOT NULL,
                             authority VARCHAR DEFAULT 'ROLE_USER',

                             CONSTRAINT fk_authorities_users FOREIGN KEY (username)
                                 REFERENCES user_registration_data (username)
                                 ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE UNIQUE INDEX IF NOT EXISTS ix_auth_username ON authorities (username,authority);

CREATE UNIQUE INDEX IF NOT EXISTS authorities_username_uindex ON authorities (username);

CREATE UNIQUE INDEX IF NOT EXISTS user_registration_data_id_uindex ON user_registration_data (id);

CREATE UNIQUE INDEX IF NOT EXISTS user_registration_data_username_uindex ON user_registration_data (username);

INSERT INTO user_registration_data (username, password)
VALUES ('user','$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a');

INSERT INTO authorities (username)
VALUES ('user');

INSERT INTO user_registration_data (username, password)
VALUES ('user2','$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a');

INSERT INTO authorities (username)
VALUES ('user2');
