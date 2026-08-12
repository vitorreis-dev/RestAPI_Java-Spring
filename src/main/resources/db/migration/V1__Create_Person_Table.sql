CREATE TABLE tb_person
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(150) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    cpf        VARCHAR(11)  NOT NULL,
    password   VARCHAR(255) NOT NULL
);
