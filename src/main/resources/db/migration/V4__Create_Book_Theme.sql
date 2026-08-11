CREATE TABLE tb_book_theme (
                               book_id BIGINT NOT NULL,
                               theme_id BIGINT NOT NULL,

                               PRIMARY KEY (book_id, theme_id),

                               CONSTRAINT fk_book_theme_book
                                   FOREIGN KEY (book_id)
                                       REFERENCES tb_book(id),

                               CONSTRAINT fk_book_theme_theme
                                   FOREIGN KEY (theme_id)
                                       REFERENCES tb_theme(id)
);