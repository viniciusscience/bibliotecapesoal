package br.com.triersistemas.bibliotecapessoal.repository;

import br.com.triersistemas.bibliotecapessoal.domain.Livro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivroRepository {
    List<Livro> consultar();
    Optional<Livro> consultar(UUID id);
    void cadastrar(Livro livro);
    void excluir(Livro livro);
}
