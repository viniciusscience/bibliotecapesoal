package br.com.triersistemas.bibliotecapessoal.service;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;
import br.com.triersistemas.bibliotecapessoal.model.ModificaLojaModel;

import java.util.List;
import java.util.UUID;

public interface LivroDesejoService {

    List<LivroDesejo> consultar();
    LivroDesejo consultar(UUID id);
    LivroDesejo cadastrar(LivroDesejoModel model);
    LivroDesejo alterar(UUID id, LivroDesejoModel model);
    LivroDesejo adicionarLoja(UUID id, LojaModel model);
    LivroDesejo modificarLoja(UUID id, ModificaLojaModel model);
    LivroDesejo excluirLoja(UUID id, ModificaLojaModel model);
    LivroDesejo excluir(UUID id);
}
