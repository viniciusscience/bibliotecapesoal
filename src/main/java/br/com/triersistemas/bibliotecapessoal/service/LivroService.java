package br.com.triersistemas.bibliotecapessoal.service;

import br.com.triersistemas.bibliotecapessoal.domain.Livro;
import br.com.triersistemas.bibliotecapessoal.model.LivroModel;
import br.com.triersistemas.bibliotecapessoal.model.PagLidasModel;

import java.util.List;
import java.util.UUID;

public interface LivroService {
    List<Livro> consultar();
    Livro consultar(UUID id);
    Livro cadastrar(LivroModel model);
    Livro editar(UUID id, LivroModel model);
    Livro adicionarPagLidas(UUID id, PagLidasModel model);

    Livro excluir(UUID id);
}
