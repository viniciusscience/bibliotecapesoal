package br.com.triersistemas.bibliotecapessoal.repository;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivroDesejoRepository {

    List<LivroDesejo> consultar();
    Optional<LivroDesejo> consultar(UUID id);
    void cadastrar(LivroDesejo livroDesejo);
    void excluir(LivroDesejo livroDesejo);

}
