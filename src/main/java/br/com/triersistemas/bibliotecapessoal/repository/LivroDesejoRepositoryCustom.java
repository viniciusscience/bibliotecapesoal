package br.com.triersistemas.bibliotecapessoal.repository;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;

import java.util.List;

public interface LivroDesejoRepositoryCustom {
    List<LivroDesejo> ListarPorAutor(String nome);
}
