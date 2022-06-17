package br.com.triersistemas.pessoalbiblioteca.repository;

import br.com.triersistemas.pessoalbiblioteca.domain.Livro;

import java.util.List;
import java.util.UUID;

public interface LivroRepository {
    List<Livro> consultar();
    Livro consultar(UUID id);
    Livro cadastrar(Livro livro);
    Livro excluir(Livro livro);
}
