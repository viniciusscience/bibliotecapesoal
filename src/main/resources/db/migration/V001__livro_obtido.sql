CREATE TABLE livro_obtido(
    id UUID PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    paginas NUMERIC NOT NULL,
    paginas_lidas NUMERIC NOT NULL,
    ano NUMERIC NOT NULL,
    leitura VARCHAR(30)
);