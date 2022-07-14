package br.com.triersistemas.bibliotecapessoal.repository;

import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LojaRepository extends JpaRepository<Loja, UUID> {

    @Query(value = "SELECT * FROM loja l WHERE l.livro_desejo_id = ?1 ORDER BY preco ASC LIMIT 1", nativeQuery = true)
    Loja buscarLojaMenorPreco(UUID id);
}
