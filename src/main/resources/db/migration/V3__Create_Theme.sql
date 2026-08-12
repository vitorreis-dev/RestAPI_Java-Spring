CREATE TABLE tb_theme (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO tb_theme (name)
VALUES
    ('Romance'),
    ('Fantasy'),
    ('Horror'),
    ('Mystery'),
    ('Science Fiction');

ALTER TABLE tb_book
    ADD CONSTRAINT fk_book_theme
        FOREIGN KEY (theme_id)
            REFERENCES tb_theme (id);
