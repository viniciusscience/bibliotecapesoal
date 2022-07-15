ALTER TABLE livro_obtido ADD COLUMN data_lido TIMESTAMP;

CREATE OR REPLACE FUNCTION atualiza_livro_obtido_fc() RETURNS TRIGGER AS $$
    BEGIN
        IF (TG_OP = 'UPDATE') THEN
             IF (NEW.paginas_lidas = NEW.paginas) THEN
                NEW.data_lido = NOW();
            END IF;
        END IF;
        RETURN NEW;
    END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER atualiza_data_lido_tg BEFORE UPDATE
    ON livro_obtido FOR EACH ROW
EXECUTE PROCEDURE atualiza_livro_obtido_fc();