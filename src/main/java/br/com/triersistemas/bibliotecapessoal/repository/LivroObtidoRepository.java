package br.com.triersistemas.bibliotecapessoal.repository;

import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivroObtidoRepository {
    List<LivroObtido> consultar();
    Optional<LivroObtido> consultar(UUID id);
    void cadastrar(LivroObtido livro);
    void excluir(LivroObtido livro);
}
