package br.com.triersistemas.bibliotecapessoal.repository;

import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.model.LivroObtidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface LivroObtidoRepository extends JpaRepository<LivroObtido, UUID> {
    List<LivroObtido> findByAutorContains(String nome);

}
