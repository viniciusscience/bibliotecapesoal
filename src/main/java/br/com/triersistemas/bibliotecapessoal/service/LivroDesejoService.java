package br.com.triersistemas.bibliotecapessoal.service;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import br.com.triersistemas.bibliotecapessoal.model.ExcluiLojaModel;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;
import br.com.triersistemas.bibliotecapessoal.model.ModificaLojaModel;

import java.util.List;
import java.util.UUID;

public interface LivroDesejoService {

    List<LivroDesejo> consultar();
    LivroDesejo consultar(UUID id);
    LivroDesejo cadastrar(LivroDesejoModel model);
    LivroDesejo editar(UUID id, LivroDesejoModel model);
    LivroDesejo adicionarLoja(UUID id, LojaModel model);
    LivroDesejo modificarLoja(UUID id, ModificaLojaModel model);
    LivroDesejo excluirLoja(UUID id, UUID idLoja);
    LivroObtido livroObtido(UUID id);
    LivroDesejo excluir(UUID id);


}
