package br.com.triersistemas.bibliotecapessoal.service;

import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.model.LivroObtidoModel;
import br.com.triersistemas.bibliotecapessoal.model.PagLidasModel;

import java.util.List;
import java.util.UUID;

public interface LivroObtidoService {
    List<LivroObtidoModel> consultar();
    LivroObtidoModel consultar(UUID id);
    LivroObtidoModel cadastrar(LivroObtidoModel model);
    void cadastrar(LivroObtido livroObtido);
    LivroObtidoModel editar(LivroObtidoModel model);
    LivroObtidoModel adicionarPagLidas(UUID id, PagLidasModel model);
    LivroObtidoModel excluir(UUID id);
}
