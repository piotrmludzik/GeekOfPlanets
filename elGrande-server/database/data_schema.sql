CREATE TABLE "user" (
                      id       SERIAL PRIMARY KEY NOT NULL,
                      cell     CHAR(250) NOT NULL
);

CREATE TABLE user_registration_data (
                        id        SERIAL PRIMARY KEY NOT NULL,
                        user_id   SERIAL NOT NULL,
                        login     CHAR(250) NOT NULL,
                        password  CHAR(250) NOT NULL
);

ALTER TABLE ONLY user_registration_data ADD CONSTRAINT fk_user_id
    FOREIGN KEY (user_id) REFERENCES "user"(id);
