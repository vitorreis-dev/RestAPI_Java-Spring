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
