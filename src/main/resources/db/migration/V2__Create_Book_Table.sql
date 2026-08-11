CREATE TABLE tb_book
(
    id         BIGSERIAL PRIMARY KEY,
    title       VARCHAR(150) NOT NULL,
    author       VARCHAR(150) NOT NULL,
    year      date NOT NULL
);