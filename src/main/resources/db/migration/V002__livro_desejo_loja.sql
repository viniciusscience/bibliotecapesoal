CREATE TABLE livro_desejo(
    id UUID PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    paginas NUMERIC NOT NULL,
    ano NUMERIC NOT NULL
);

CREATE TABLE loja(
  id UUID PRIMARY KEY,
  preco NUMERIC(10, 2) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  livro_desejo_id UUID REFERENCES livro_desejo(id)
);