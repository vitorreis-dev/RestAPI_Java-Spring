CREATE TABLE tb_person
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(150) NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE,
    cpf        VARCHAR(11)  NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL
);
