CREATE TABLE tb_book
(
    id               BIGSERIAL PRIMARY KEY,
    title            VARCHAR(150) NOT NULL,
    author           VARCHAR(150) NOT NULL,
    publication_year date         NOT NULL,
    theme_id         BIGINT
);
