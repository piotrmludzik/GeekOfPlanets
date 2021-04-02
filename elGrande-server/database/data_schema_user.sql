CREATE TABLE user_registration_data (
                                        id         SERIAL PRIMARY KEY NOT NULL,
                                        user_id    SERIAL NOT NULL,
                                        username   CHAR(250) UNIQUE NOT NULL,
                                        password   CHAR(250) NOT NULL,
                                        enabled    INT2 NOT NULL DEFAULT 1
);

CREATE TABLE authorities (
                             username CHAR(250) UNIQUE NOT NULL,
                             authority CHAR(250) NOT NULL DEFAULT 'USER'
);

ALTER TABLE ONLY authorities ADD CONSTRAINT fk_username
    FOREIGN KEY (username) REFERENCES user_registration_data(username);
