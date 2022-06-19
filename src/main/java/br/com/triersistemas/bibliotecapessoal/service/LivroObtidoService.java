package br.com.triersistemas.bibliotecapessoal.service;

import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.model.LivroObtidoModel;
import br.com.triersistemas.bibliotecapessoal.model.PagLidasModel;

import java.util.List;
import java.util.UUID;

public interface LivroObtidoService {
    List<LivroObtido> consultar();
    LivroObtido consultar(UUID id);
    LivroObtido cadastrar(LivroObtidoModel model);
    void cadastrar(LivroObtido livroObtido);
    LivroObtido editar(UUID id, LivroObtidoModel model);
    LivroObtido adicionarPagLidas(UUID id, PagLidasModel model);
    LivroObtido excluir(UUID id);
}
